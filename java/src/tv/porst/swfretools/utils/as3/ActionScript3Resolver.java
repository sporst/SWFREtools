package tv.porst.swfretools.utils.as3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tv.porst.swfretools.parser.structures.AS3Code;
import tv.porst.swfretools.parser.structures.AS3Data;
import tv.porst.swfretools.parser.structures.ClassInfo;
import tv.porst.swfretools.parser.structures.ConstantPool;
import tv.porst.swfretools.parser.structures.InstanceInfo;
import tv.porst.swfretools.parser.structures.MethodBody;
import tv.porst.swfretools.parser.structures.MethodBodyList;
import tv.porst.swfretools.parser.structures.MethodInfo;
import tv.porst.swfretools.parser.structures.MethodInfoList;
import tv.porst.swfretools.parser.structures.MultinameInfo;
import tv.porst.swfretools.parser.structures.MultinameInfoList;
import tv.porst.swfretools.parser.structures.NamespaceInfoList;
import tv.porst.swfretools.parser.structures.StringInfoList;
import tv.porst.swfretools.parser.structures.TraitMethod;
import tv.porst.swfretools.parser.structures.TraitsInfo;
import tv.porst.swfretools.parser.structures.TraitsInfoList;
import tv.porst.swfretools.utils.ActionScript3Helpers;
import tv.porst.swfretools.utils.ResolverException;

/**
 * This class can take ActionScript 3 information and resolve all the classes
 * and methods that belong to all of the classes. This is very important as the
 * information that is stored in ActionScript 3 data in an SWF file is very
 * fragmented and must be reconstructed before it can be used in any useful
 * way, for example to display the ActionScript 3 code in the GUI.
 * 
 * This class takes all the fragmented data and turns it into something saner
 * that can easily be processed. While processing the data, this class is
 * extremely conservative with errors. Even when, for example, the name of a
 * function can not be resolved, the code will still continue and try to
 * resolve other aspects of the function such as its return type or its
 * arguments. This is important as we can expect this resolver class to try
 * make sense of fuzzed ActionScript 3 code in the future.
 */
public final class ActionScript3Resolver {

	/**
	 * This function creates a mapping between method headers and method bodies.
	 * This is important because whenever a method is referenced, it is
	 * referenced as an ID into the table of method headers. There is no quick
	 * way to map from method header to method body though, for example to
	 * find the code associated with a method. Therefore we just pre-calculate
	 * this mapping and pass it to all functions that require it.
	 * 
	 * @param data The ActionScript 3 data that provides method header and
	 * method body information.
	 * @param errors Errors that occur during resolving are logged here.
	 * 
	 * @return A mapping from method info objects to objects that give
	 * information about the method body.
	 */
	private static Map<MethodInfo, ResolvedFunction> createMethodInformationMapping(final AS3Data data, final List<String> errors) {

		assert data != null : "Data argument must not be null";
		assert errors != null : "Errors argument must not be null";

		final Map<MethodInfo, ResolvedFunction> methodMapping = new HashMap<MethodInfo, ResolvedFunction>();

		final MethodInfoList methodInfos = data.getMethodInfos();
		final MethodBodyList methodBodies = data.getMethodBodies();

		final ConstantPool constantPool = data.getConstantPool();
		final StringInfoList constantStrings = constantPool.getStrings();
		final MultinameInfoList multiNames = constantPool.getMultinames();
		final NamespaceInfoList namespaces = constantPool.getNamespaces();

		// In the first round we are using the existing mapping between method bodies
		// and method information fields to create the inverse mapping.
		for (final MethodBody methodBody : methodBodies) {

			final int methodIndex = methodBody.getMethod().value();

			if (methodIndex >= methodInfos.size()) {
				errors.add(String.format("Can not find method header for method %d because method header ID is out of bounds", methodIndex));
			}
			else {
				final MethodInfo methodInfo = data.getMethodInfos().get(methodIndex);

				final AS3Code code = methodBody.getCode();

				final ResolvedFunction resolvedMethod = resolveFunction(methodInfo, code, constantStrings, multiNames, namespaces, errors);
				methodMapping.put(methodInfo, resolvedMethod);
			}
		}

		// In the second round we are processing all those method information
		// fields that do not have an associated method body. Those are the
		// methods that do not contain any ActionScript 3 code.
		for (final MethodInfo methodInfo : data.getMethodInfos()) {

			if (methodMapping.containsKey(methodInfo)) {
				continue;
			}

			final ResolvedFunction resolvedMethod = resolveFunction(methodInfo, null, constantStrings, multiNames, namespaces, errors);
			methodMapping.put(methodInfo, resolvedMethod);
		}

		return methodMapping;
	}

	/**
	 * Reconstructs the given class and its methods.
	 * 
	 * @param data The fragmented ActionScript 3 data.
	 * @param classInfo The class information of the class.
	 * @param instanceInfo The instance information of the class.
	 * @param methodMapping The previously generated mapping between method
	 * headers and their associated method bodies.
	 * @param errors Errors that occur during resolving are logged here.
	 * 
	 * @return A list of all classes defined in the ActionScript 3 code.
	 */
	private static ResolvedClass resolveClass(final AS3Data data, final ClassInfo classInfo, final InstanceInfo instanceInfo, final Map<MethodInfo, ResolvedFunction> methodMapping, final List<String> errors) {

		assert data != null : "Data argument must not be null";
		assert classInfo != null : "Class Info argument must not be null";
		assert instanceInfo != null : "Instance Info argument must not be null";
		assert methodMapping != null : "Method mapping argument must not be null";
		assert errors != null : "Errors list must not be null";

		final ConstantPool constantPool = data.getConstantPool();
		final StringInfoList constantStrings = constantPool.getStrings();
		final MultinameInfoList multiNames = constantPool.getMultinames();
		final NamespaceInfoList namespaces = constantPool.getNamespaces();
		final MethodInfoList methodList = data.getMethodInfos();

		final ResolvedMethod staticConstructor = resolveStaticConstructor(classInfo, data, methodMapping, errors);
		final ResolvedMethod constructor = resolveConstructor(instanceInfo, data, methodMapping, errors);

		final String[] className = resolveClassName(instanceInfo, constantStrings, multiNames, namespaces, errors);
		final List<ResolvedMethod> methods = resolveMethods(instanceInfo.getTraits(), methodList, methodMapping, constantStrings, multiNames, namespaces, errors);

		return new ResolvedClass(className, methods, staticConstructor, constructor);
	}

	/**
	 * Takes the fragmented information from the ActionScript 3 data and
	 * reconstructs the defined classes and their methods.
	 * 
	 * @param data The fragmented ActionScript 3 data.
	 * @param methodMapping The previously generated mapping between method
	 * headers and their associated method bodies.
	 * @param errors Errors that occur during resolving are logged here.
	 * 
	 * @return A list of all classes defined in the ActionScript 3 code.
	 */
	private static List<ResolvedClass> resolveClasses(final AS3Data data, final Map<MethodInfo, ResolvedFunction> methodMapping, final List<String> errors) {

		assert data != null : "Data argument must not be null";
		assert methodMapping != null : "Method mapping argument must not be null";
		assert errors != null : "Errors list must not be null";

		final List<ResolvedClass> classes = new ArrayList<ResolvedClass>();

		for (int i=0;i<data.getClassCount().value();i++) {

			if (i >= data.getClasses().size()) {
				errors.add(String.format("Class at offset %08X could not be resolved as its class index is out of bounds"));
				continue;
			}

			if (i >= data.getInstances().size()) {
				errors.add(String.format("Class at offset %08X could not be resolved as its instance index is out of bounds"));
				continue;
			}

			final ClassInfo classInfo = data.getClasses().get(i);
			final InstanceInfo instanceInfo = data.getInstances().get(i);

			classes.add(resolveClass(data, classInfo, instanceInfo, methodMapping, errors));
		}

		return classes;
	}

	/**
	 * Resolves the name of a class.
	 * 
	 * @param instanceInfo The instance information of the class whose name is returned.
	 * @param constantStringList List of constant strings from the ActionScript 3 data.
	 * @param multinameList List of multinames from the ActionScript 3 data.
	 * @param namespaceList List of namespaces from the ActionScript 3 data.
	 * @param errors Errors that occur during resolving are logged here.
	 * 
	 * @return The fully qualified name of the class.
	 */
	private static String[] resolveClassName(final InstanceInfo instanceInfo, final StringInfoList constantStringList, final MultinameInfoList multinameList, final NamespaceInfoList namespaceList, final List<String> errors) {

		assert instanceInfo != null : "Instance information argument must not be null";
		assert constantStringList != null : "Constant string list argument must not be null";
		assert multinameList != null : "Multiname list argument must not be null";
		assert namespaceList != null : "Namespace list argument must not be null";
		assert errors != null : "Errors list must not be null";

		final int classNameIndex = instanceInfo.getName().value();

		if (classNameIndex == 0) {
			// Not totally sure what to do here.
			return new String[] { "???"};
		}
		else if (classNameIndex - 1 >= multinameList.size()) {
			errors.add(String.format("The class name of the function at address %08X could not be resolved as the name index is out of bounds", instanceInfo.getBitPosition() / 8));
			return null;
		}
		else {
			final MultinameInfo multinameInfo = multinameList.get(classNameIndex - 1);

			try {
				return ActionScript3Helpers.resolveMultiname(multinameInfo, constantStringList, namespaceList);
			} catch (final ResolverException e) {
				errors.add(String.format("The class name of the function at address %08X could not be resolved as the name index is out of bounds", instanceInfo.getBitPosition() / 8));
				return null;
			}
		}
	}

	/**
	 * Resolves the constructor of a class.
	 * 
	 * @param instanceInfo The class whose constructor is resolved.
	 * @param data The fragmented ActionScript 3 data.
	 * @param methodMapping The previously generated mapping between method
	 * headers and their bodies.
	 * @param errors Errors that occur during resolving are logged here.
	 * 
	 * @return The resolved constructor for the given class or null if
	 * the constructor could not be resolved.
	 */
	private static ResolvedMethod resolveConstructor(final InstanceInfo instanceInfo, final AS3Data data, final Map<MethodInfo, ResolvedFunction> methodMapping, final List<String> errors) {

		assert instanceInfo != null : "Instance information argument must not be null";
		assert data != null : "Data argument must not be null";
		assert methodMapping != null : "Method mapping argument must not be null";
		assert errors != null : "Errors list must not be null";

		final int constructorId = instanceInfo.getIinit().value();

		final MethodInfoList methodInfos = data.getMethodInfos();

		if (constructorId >= methodInfos.size()) {
			errors.add(String.format("The constructor of the class at offset %08X could not be resolved as its method index is out of bounds", instanceInfo.getBitPosition() / 8));
			return null;
		}
		else {
			final ResolvedFunction resolvedConstructor = methodMapping.get(methodInfos.get(constructorId));
			return new ResolvedMethod(new String[0], new String[] { "constructor" }, resolvedConstructor.getArguments(), resolvedConstructor == null ? null : resolvedConstructor.getCode());
		}
	}

	/**
	 * This function takes all the information that is required to create
	 * resolved function object that contains information about a function
	 * such as its name, return type, argument types, and function body.
	 * 
	 * @param methodInfo Header information of the function to resolve.
	 * @param code ActionScript code that forms the function body.
	 * This value can be null for functions without associated code.
	 * @param constantStringList List of constant strings from the ActionScript 3 data.
	 * @param multinameList List of multinames from the ActionScript 3 data.
	 * @param namespaceList List of namespaces from the ActionScript 3 data.
	 * @param errors Errors that occur during resolving are logged here.
	 * 
	 * @return The resolved function object.
	 */
	private static ResolvedFunction resolveFunction(final MethodInfo methodInfo, final AS3Code code, final StringInfoList constantStringList, final MultinameInfoList multinameList, final NamespaceInfoList namespaceList, final List<String> errors) {

		assert methodInfo != null : "Method information argument must not be null";
		assert constantStringList != null : "Constant string list argument must not be null";
		assert multinameList != null : "Multiname list argument must not be null";
		assert namespaceList != null : "Namespace list argument must not be null";
		assert errors != null : "Errors list must not be null";

		final String name = resolveFunctionName(methodInfo, constantStringList, errors);
		final String[] returnType = resolveFunctionReturnType(methodInfo, constantStringList, multinameList, namespaceList, errors);
		final List<String[]> arguments = resolveFunctionArguments(methodInfo, constantStringList, multinameList, namespaceList, errors);

		return new ResolvedFunction(name, returnType, arguments, code);
	}

	/**
	 * Resolves all the argument value types of a method.
	 * 
	 * @param methodInfo Header information of the function to resolve.
	 * This value can be null for functions without associated code.
	 * @param constantStringList List of constant strings from the ActionScript 3 data.
	 * @param multinameList List of multinames from the ActionScript 3 data.
	 * @param namespaceList List of namespaces from the ActionScript 3 data.
	 * @param errors Errors that occur during resolving are logged here.
	 * 
	 * @return A list of the fully qualified types of the function arguments.
	 */
	private static List<String[]> resolveFunctionArguments(final MethodInfo methodInfo, final StringInfoList constantStringList, final MultinameInfoList multinameList, final NamespaceInfoList namespaceList, final List<String> errors) {

		assert methodInfo != null : "Method information argument must not be null";
		assert constantStringList != null : "Constant string list argument must not be null";
		assert multinameList != null : "Multiname list argument must not be null";
		assert namespaceList != null : "Namespace list argument must not be null";
		assert errors != null : "Errors list must not be null";

		final List<String[]> arguments = new ArrayList<String[]>();

		for (int i=0;i<methodInfo.getParamTypes().size();i++) {

			final int paramTypeIndex = methodInfo.getParamTypes().get(i).value();

			if (paramTypeIndex == 0) {
				// Type index 0 means the argument can be of any type.
				arguments.add(new String[] { "*" });
			}
			else if (paramTypeIndex - 1 >= multinameList.size()) {
				errors.add(String.format("Could not resolve argument of function at offset %08X because name index is out of bounds", methodInfo.getBitPosition() / 8));
				arguments.add(null);
			}
			else {
				final MultinameInfo multinameInfo = multinameList.get(paramTypeIndex - 1);

				try {
					final String[] name = ActionScript3Helpers.resolveMultiname(multinameInfo, constantStringList, namespaceList);
					arguments.add(name);
				} catch (final ResolverException e) {
					errors.add(String.format("Could not resolve argument of function at offset %08X because name index is out of bounds", methodInfo.getBitPosition() / 8));
				}
			}
		}

		return arguments;
	}

	/**
	 * Tries to resolve the name of a method.
	 * 
	 * @param methodInfo Method header information of the method to process.
	 * @param constantStringList List of constant strings from the ActionScript 3 data.
	 * @param errors Errors that occur during resolving are logged here.
	 * 
	 * @return The name of the function or null if it could not be resolved.
	 */
	private static String resolveFunctionName(final MethodInfo methodInfo, final StringInfoList constantStringList, final List<String> errors) {

		assert methodInfo != null : "Method information argument must not be null";
		assert constantStringList != null : "Constant string list argument must not be null";

		final int nameIndex = methodInfo.getName().value();

		if (nameIndex >= constantStringList.size()) {
			errors.add(String.format("Could not resolve name of function at offset %08X because name index is out of bounds", methodInfo.getBitPosition() / 8));
			return null;
		}
		else {
			return constantStringList.get(nameIndex).getName().value();
		}
	}

	/**
	 * Resolves the return type of a function.
	 * 
	 * @param methodInfo Method information of the functions whose return type is resolved.
	 * @param constantStringList List of constant strings from the ActionScript 3 data.
	 * @param multinameList List of multinames from the ActionScript 3 data.
	 * @param namespaceList List of namespaces from the ActionScript 3 data.
	 * @param errors Errors that occur during resolving are logged here.
	 * 
	 * @return An array containing all the individual parts of the fully qualified
	 * name of the function return type.
	 */
	private static String[] resolveFunctionReturnType(final MethodInfo methodInfo, final StringInfoList constantStringList, final MultinameInfoList multinameList, final NamespaceInfoList namespaceList, final List<String> errors) {

		assert methodInfo != null : "Method information argument must not be null";
		assert constantStringList != null : "Constant string list argument must not be null";
		assert multinameList != null : "Multiname list argument must not be null";
		assert namespaceList != null : "Namespace list argument must not be null";
		assert errors != null : "Errors list must not be null";

		final int returnTypeIndex = methodInfo.getReturnType().value();

		if (returnTypeIndex == 0) {
			// Return type index 0 means the return value can be of any type.
			return new String[] { "*" };
		}
		else if (returnTypeIndex - 1 >= multinameList.size()) {
			errors.add(String.format("Return type of method at offset %08X could not be resolved because its return type index is out of bounds", methodInfo.getBitPosition() / 8));
			return null;
		}
		else {
			final MultinameInfo multinameInfo = multinameList.get(returnTypeIndex - 1);

			try {
				return ActionScript3Helpers.resolveMultiname(multinameInfo, constantStringList, namespaceList);
			} catch (final ResolverException e) {
				errors.add(String.format("Return type of method at offset %08X could not be resolved because its return type index is out of bounds", methodInfo.getBitPosition() / 8));
				return null;
			}
		}
	}

	/**
	 * Resolves a single class method.
	 * 
	 * @param traitsInfo The trait that defines the method.
	 * @param methodList The methods list parsed from the SWF file.
	 * @param methodMapping The previously generated mapping between method
	 * headers and their associated method bodies.
	 * @param constantStringList List of constant strings from the ActionScript 3 data.
	 * @param multinameList List of multinames from the ActionScript 3 data.
	 * @param namespaceList List of namespaces from the ActionScript 3 data.
	 * @param errors Errors that occur during resolving are logged here.
	 * 
	 * @return The resolved method or null if the method could not be resolved.
	 */
	private static ResolvedMethod resolveMethod(final TraitsInfo traitsInfo,
			final MethodInfoList methodList,
			final Map<MethodInfo, ResolvedFunction> methodMapping,
			final StringInfoList constantStringList,
			final MultinameInfoList multinameList,
			final NamespaceInfoList namespaceList,
			final List<String> errors) {

		assert traitsInfo != null : "Traits information argument must not be null";
		assert methodList != null : "Method information argument must not be null";
		assert methodMapping != null : "Method mapping argument must not be null";
		assert constantStringList != null : "Constant string list argument must not be null";
		assert multinameList != null : "Multiname list argument must not be null";
		assert namespaceList != null : "Namespace list argument must not be null";
		assert errors != null : "Errors list must not be null";

		final TraitMethod traitMethod = (TraitMethod) traitsInfo.getData();

		final int methodIndex = traitMethod.getMethod().value();

		if (methodIndex >= methodList.size()) {
			errors.add(String.format("The method at offset %08X could not be resolved as its method index is out of bounds", traitMethod.getBitPosition() / 8));
			return null;
		}

		final String[] methodName = resolveMethodName(traitsInfo, constantStringList, multinameList, namespaceList, errors);

		final MethodInfo method = methodList.get(methodIndex);
		final ResolvedFunction resolvedMethod = methodMapping.get(method);
		final AS3Code code = resolvedMethod.getCode();

		return new ResolvedMethod(resolvedMethod.getReturnType(), methodName, resolvedMethod.getArguments(), code);
	}

	/**
	 * Resolves the name of a method.
	 * 
	 * @param traitsInfo Identifies the method.
	 * @param constantStringList List of constant strings from the ActionScript 3 data.
	 * @param multinameList List of multinames from the ActionScript 3 data.
	 * @param namespaceList List of namespaces from the ActionScript 3 data.
	 * @param errors Errors that occur during resolving are logged here.
	 * 
	 * @return The fully qualified method name.
	 */
	private static String[] resolveMethodName(final TraitsInfo traitsInfo, final StringInfoList constantStringList, final MultinameInfoList multinameList, final NamespaceInfoList namespaceList, final List<String> errors) {

		assert traitsInfo != null : "Traits information argument must not be null";
		assert constantStringList != null : "Constant string list argument must not be null";
		assert multinameList != null : "Multiname list argument must not be null";
		assert namespaceList != null : "Namespace list argument must not be null";
		assert errors != null : "Errors list must not be null";

		final int nameIndex = traitsInfo.getName().value();

		if (nameIndex == 0) {
			// Not sure what to do here.
			return new String[] { "???" };
		}
		else if (nameIndex -1 >= multinameList.size()) {
			errors.add(String.format("Name of method at offset %08X could not be resolved as name index is out of bounds", traitsInfo.getBitPosition() / 8));
			return null;
		}
		else {
			final MultinameInfo multiNameInfo = multinameList.get(traitsInfo.getName().value() - 1);

			try {
				return ActionScript3Helpers.resolveMultiname(multiNameInfo, constantStringList, namespaceList);
			} catch (final ResolverException e) {
				errors.add(String.format("Name of method at offset %08X could not be resolved as name index is out of bounds", traitsInfo.getBitPosition() / 8));
				return null;
			}
		}
	}

	/**
	 * Resolves the methods of a class.
	 * 
	 * @param traits The traits of the class. These define the methods.
	 * @param methodList The methods list parsed from the SWF file.
	 * @param methodMapping The previously generated mapping between method
	 * headers and their associated method bodies.
	 * @param constantStringList List of constant strings from the ActionScript 3 data.
	 * @param multinameList List of multinames from the ActionScript 3 data.
	 * @param namespaceList List of namespaces from the ActionScript 3 data.
	 * @param errors Errors that occur during resolving are logged here.
	 * 
	 * @return The resolved methods of the class.
	 */
	private static List<ResolvedMethod> resolveMethods(final TraitsInfoList traits, final MethodInfoList methodList, final Map<MethodInfo, ResolvedFunction> methodMapping, final StringInfoList constantStringList, final MultinameInfoList multinameList, final NamespaceInfoList namespaceList, final List<String> errors) {

		assert traits != null : "Traits argument must not be null";
		assert methodList != null : "Method list argument must not be null";
		assert methodMapping != null : "Method mapping argument must not be null";
		assert constantStringList != null : "Constant string list argument must not be null";
		assert multinameList != null : "Multiname list argument must not be null";
		assert namespaceList != null : "Namespace list argument must not be null";
		assert errors != null : "Errors list must not be null";

		final List<ResolvedMethod> methods = new ArrayList<ResolvedMethod>();

		for (final TraitsInfo traitsInfo : traits) {
			if (traitsInfo.getData() instanceof TraitMethod) {
				methods.add(resolveMethod(traitsInfo, methodList, methodMapping, constantStringList, multinameList, namespaceList, errors));
			}
		}

		return methods;
	}

	/**
	 * Resolves the static constructor of a class.
	 * 
	 * @param classInfo The class whose static constructor is resolved.
	 * @param data The fragmented ActionScript 3 data.
	 * @param methodMapping The previously generated mapping between method
	 * headers and their bodies.
	 * @param errors Errors that occur during resolving are logged here.
	 * 
	 * @return The resolved static constructor for the given class or null if
	 * the static constructor could not be resolved.
	 */
	private static ResolvedMethod resolveStaticConstructor(final ClassInfo classInfo,  final AS3Data data, final Map<MethodInfo, ResolvedFunction> methodMapping, final List<String> errors) {

		assert classInfo != null : "Class info argument must not be null";
		assert data != null : "Data argument must not be null";
		assert methodMapping != null : "Method mapping argument must not be null";
		assert errors != null : "Errors list must not be null";

		final int staticConstructorId = classInfo.getcInit().value();

		final MethodInfoList methodInfos = data.getMethodInfos();

		if (staticConstructorId >= methodInfos.size()) {
			errors.add(String.format("The static constructor of the class at offset %08X could not be resolved as its method index is out of bounds", classInfo.getBitPosition() / 8));
			return null;
		}
		else {
			final ResolvedFunction resolvedStaticConstructor = methodMapping.get(methodInfos.get(staticConstructorId));
			return new ResolvedMethod(new String[0], new String[] { "staticconstructor" }, new ArrayList<String[]>(), resolvedStaticConstructor == null ? null : resolvedStaticConstructor.getCode());
		}
	}

	/**
	 * Takes fragmented ActionScript 3 data as parsed from a SWF file and turns it
	 * into something that fits the model of Flash code analysis better.
	 * 
	 * @param data The fragmented data from the SWF file.
	 * 
	 * @return The resolved ActionScript 3 code.
	 */
	public static ResolvedCode resolve(final AS3Data data) {

		if (data == null) {
			throw new IllegalArgumentException("Data argument must not be null.");
		}

		// This list is used to collect errors that occur during resolving.
		final List<String> errors = new ArrayList<String>();

		// In the first step we are creating a mapping between method headers and
		// method bodies. This is needed to quickly access method bodies later.
		final Map<MethodInfo, ResolvedFunction> methodMapping = createMethodInformationMapping(data, errors);

		// In the second step we are going through all the classes defined in the
		// input data and we are trying to recover the individual elements that
		// make up that class.
		final List<ResolvedClass> classes = resolveClasses(data, methodMapping, errors);

		return new ResolvedCode(data, classes);
	}
}