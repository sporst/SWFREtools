package tv.porst.swfretools.utils;

import tv.porst.splib.strings.StringHelpers;
import tv.porst.swfretools.parser.structures.MultinameInfo;
import tv.porst.swfretools.parser.structures.NamespaceInfo;
import tv.porst.swfretools.parser.structures.NamespaceInfoList;
import tv.porst.swfretools.parser.structures.QName;
import tv.porst.swfretools.parser.structures.StringInfoList;

/**
 * Contains helper functions for working with ActionScript 3 code.
 */
public final class ActionScript3Helpers {

	/**
	 * Looks up a namespace in a namespace list.
	 * 
	 * @param namespaceIndex Index of the namespace.
	 * @param namespaceList Provides all available namespaces.
	 * 
	 * @return The resolved namespace or null if the namespaceIndex was 0.
	 * 
	 * @throws ResolverException Thrown if the namespace could not be resolved.
	 */
	private static NamespaceInfo resolveNamespace(final int namespaceIndex, final NamespaceInfoList namespaceList) throws ResolverException {

		if (namespaceIndex == 0) {
			return null;
		}
		else if (namespaceIndex > namespaceList.size()) {
			throw new ResolverException("Invalid namespace index");
		}
		else {
			return namespaceList.get(namespaceIndex - 1);
		}
	}

	/**
	 * Looks up a string in a string info list
	 * 
	 * @param stringIndex The index of the string to look up.
	 * @param constantPool Provides the strings.
	 * 
	 * @return The looked up string or null if the string index was 0.
	 * 
	 * @throws ResolverException Thrown if the string could not be looked up.
	 */
	private static String resolveString(final int stringIndex, final StringInfoList constantPool) throws ResolverException {

		if (stringIndex == 0) {
			return null;
		}
		else if (stringIndex > constantPool.size()) {
			throw new ResolverException("Invalid string index");
		}
		else {
			return constantPool.get(stringIndex - 1).getName().value();
		}
	}

	/**
	 * Flattens a multi-part namespace string into a single string.
	 * 
	 * @param namespaceParts The parts of the namespace.
	 * 
	 * @return The flattened namespace string.
	 */
	public static String flattenNamespaceName(final String[] namespaceParts) {

		if (namespaceParts == null) {
			throw new IllegalArgumentException("Namespace parts argument must not be null.");
		}

		return StringHelpers.join(namespaceParts, ":");
	}

	/**
	 * Returns the individual components of a multiname namespace in string form.
	 * 
	 * @param multinameInfo The multiname namespace to resolve.
	 * @param constantPool Provides the constant strings for the resolved namespace.
	 * @param namespaceList Provides the available namespace.
	 * 
	 * @return The individual components of the resolved multiname namespace.
	 * 
	 * @throws ResolverException Thrown if the namespace could not be resolved.
	 */
	public static String[] resolveMultiname(final MultinameInfo multinameInfo, final StringInfoList constantPool, final NamespaceInfoList namespaceList) throws ResolverException {

		if (multinameInfo == null) {
			throw new IllegalArgumentException("MultinameInfo argument must not be null.");
		}

		if (constantPool == null) {
			throw new IllegalArgumentException("ConstantPool argument must not be null.");
		}

		if (namespaceList == null) {
			throw new IllegalArgumentException("NamespaceList argument must not be null.");
		}

		if (multinameInfo.getKind().value() == 7) {
			final QName qname = (QName) multinameInfo.getData();

			final int ns = qname.getNs().value();
			final int nameIndex = qname.getName().value();

			final NamespaceInfo namespace = resolveNamespace(ns, namespaceList);

			if (namespace == null) {
				return new String[0];
			}

			final int namespaceNameIndex = namespace.getName().value();
			final String namespaceName = resolveString(namespaceNameIndex, constantPool);

			final String name = resolveString(nameIndex, constantPool);

			return new String[] { namespaceName, name };
		}
		else {
			return new String[0];
		}
	}

}
