package tv.porst.swfretools.utils.as3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tv.porst.swfretools.parser.structures.AS3Data;
import tv.porst.swfretools.parser.structures.MultinameInfo;
import tv.porst.swfretools.parser.structures.MultinameInfoList;
import tv.porst.swfretools.utils.ActionScript3Helpers;
import tv.porst.swfretools.utils.ResolverException;

public class ResolvedCode {

	private final List<ResolvedClass> classes;
	private final AS3Data data;

	private final Map<Integer, String[]> resolvedMultinames = new HashMap<Integer, String[]>();

	public ResolvedCode(final AS3Data data, final List<ResolvedClass> classes) {
		this.data = data;
		this.classes = new ArrayList<ResolvedClass>(classes);
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public List<ResolvedClass> getClasses() {
		return new ArrayList<ResolvedClass>(classes);
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public AS3Data getData() {
		return data;
	}

	public Double resolveDouble(final int index) {
		if (index >= data.getConstantPool().getDoubles().size()) {
			return null;
		}
		else {
			return data.getConstantPool().getDoubles().get(index).value();
		}
	}

	public Long resolveInteger(final int index) {
		if (index >= data.getConstantPool().getIntegers().size()) {
			return null;
		}
		else {
			return data.getConstantPool().getIntegers().get(index).value();
		}
	}

	public String[] resolveMultiname(final int index) {

		if (resolvedMultinames.containsKey(index)) {
			return resolvedMultinames.get(index);
		}

		final MultinameInfoList multinames = data.getConstantPool().getMultinames();

		final MultinameInfo multiname = multinames.get(index - 1);

		try {
			final String[] namespaceParts = ActionScript3Helpers.resolveMultiname(multiname, data.getConstantPool().getStrings(), data.getConstantPool().getNamespaces());

			resolvedMultinames.put(index, namespaceParts);

			return namespaceParts;

		} catch (final ResolverException e) {
			return null;
		}
	}

	public String resolveString(final int index) {
		if (index >= data.getConstantPool().getStrings().size()) {
			return null;
		}
		else {
			return data.getConstantPool().getStrings().get(index).getName().value();
		}
	}

	public Long resolveUInteger(final int index) {
		if (index >= data.getConstantPool().getUintegers().size()) {
			return null;
		}
		else {
			return data.getConstantPool().getUintegers().get(index).value();
		}
	}
}
