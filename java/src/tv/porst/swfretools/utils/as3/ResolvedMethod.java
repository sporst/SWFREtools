package tv.porst.swfretools.utils.as3;

import java.util.ArrayList;
import java.util.List;

import tv.porst.swfretools.parser.structures.AS3Code;

/**
 * Represents a resolved method.
 */
public class ResolvedMethod {

	/**
	 * The fully qualified return type of the method.
	 */
	private final String[] returnType;

	/**
	 * The fully qualified method name.
	 */
	private final String[] methodName;

	/**
	 * List of fully qualified argument types.
	 */
	private final List<String[]> arguments;

	/**
	 * Code of the method.
	 */
	private final AS3Code code;

	/**
	 * Creates a new resolved method object.
	 * 
	 * @param returnType The fully qualified return type of the method.
	 * @param methodName The fully qualified method name.
	 * @param arguments List of fully qualified argument types.
	 * @param code Code of the method.
	 */
	public ResolvedMethod(final String[] returnType, final String[] methodName, final List<String[]> arguments, final AS3Code code) {

		if (returnType == null) {
			throw new IllegalArgumentException("Return type argument must not be null.");
		}

		if (methodName == null) {
			throw new IllegalArgumentException("Method name argument must not be null.");
		}

		if (arguments == null) {
			throw new IllegalArgumentException("Arguments argument must not be null.");
		}

		this.returnType = returnType.clone();
		this.methodName = methodName.clone();
		this.arguments = new ArrayList<String[]>(arguments);
		this.code = code;
	}

	/**
	 * Returns the list of fully qualified argument types.
	 *
	 * @return The list of fully qualified argument types.
	 */
	public List<String[]> getArguments() {
		return new ArrayList<String[]>(arguments);
	}

	/**
	 * Returns the code of the method.
	 * 
	 * @return The code of the method.
	 */
	public AS3Code getCode() {
		return code;
	}

	/**
	 * Returns the fully qualified method name.
	 *
	 * @return The fully qualified method name.
	 */
	public String[] getName() {
		return methodName.clone();
	}

	/**
	 * Returns the fully qualified return type of the method.
	 *
	 * @return The fully qualified return type of the method.
	 */
	public String[] getReturnType() {
		return returnType.clone();
	}
}
