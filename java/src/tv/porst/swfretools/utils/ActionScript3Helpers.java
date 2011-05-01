package tv.porst.swfretools.utils;

import tv.porst.swfretools.parser.structures.MultinameInfo;
import tv.porst.swfretools.parser.structures.NamespaceInfo;
import tv.porst.swfretools.parser.structures.NamespaceInfoList;
import tv.porst.swfretools.parser.structures.QName;
import tv.porst.swfretools.parser.structures.StringInfoList;

public class ActionScript3Helpers {

	private static NamespaceInfo resolveNamespace(final int ns, final NamespaceInfoList namespaceList) throws ResolverException {

		if (ns == 0) {
			return null;
		}
		else if (ns > namespaceList.size()) {
			throw new ResolverException("Invalid namespace index");
		}
		else {
			return namespaceList.get(ns - 1);
		}
	}

	private static String resolveString(final int namespaceNameIndex, final StringInfoList constantPool) throws ResolverException {

		if (namespaceNameIndex == 0) {
			return null;
		}
		else if (namespaceNameIndex > constantPool.size()) {
			throw new ResolverException("Invalid string index");
		}
		else {
			return constantPool.get(namespaceNameIndex - 1).getName().value();
		}
	}

	public static String flattenNamespaceName(final String[] namespaceParts) {
		final StringBuilder builder = new StringBuilder();

		for (final String namespaceName : namespaceParts) {
			if (namespaceName == namespaceParts[0] && (namespaceName == null || namespaceName.equals(""))) {
				continue;
			}

			if (builder.length() != 0) {
				builder.append(":");
			}

			builder.append(namespaceName);
		}

		return builder.toString();
	}

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
