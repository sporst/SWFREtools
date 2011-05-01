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

/**
 * Represents ActionScript 3 data in a way that is easier to work with than
 * the standard representation as directly parsed from a SWF file.
 */
public final class ResolvedCode {

	/**
	 * The parsed ActionScript 3 data this class represents.
	 */
	private final AS3Data data;

	/**
	 * The resolved classes that are part of the ActionScript 3 data.
	 */
	private final List<ResolvedClass> classes;

	/**
	 * Map that caches multinames.
	 */
	private final Map<Integer, String[]> resolvedMultinames = new HashMap<Integer, String[]>();

	/**
	 * Creates a new resolved code object.
	 * 
	 * @param data The parsed ActionScript 3 data this class represents.
	 * @param classes The resolved classes that are part of the ActionScript 3 data.
	 */
	public ResolvedCode(final AS3Data data, final List<ResolvedClass> classes) {

		if (data == null) {
			throw new IllegalArgumentException("Data argument must not be null.");
		}

		if (classes == null) {
			throw new IllegalArgumentException("Classes argument must not be null.");
		}

		this.data = data;
		this.classes = new ArrayList<ResolvedClass>(classes);
	}

	/**
	 * Returns the resolved classes that are part of the ActionScript 3 data.
	 *
	 * @return The resolved classes that are part of the ActionScript 3 data.
	 */
	public List<ResolvedClass> getClasses() {
		return new ArrayList<ResolvedClass>(classes);
	}

	/**
	 * Returns the parsed ActionScript 3 data this class represents.
	 *
	 * @return The parsed ActionScript 3 data this class represents.
	 */
	public AS3Data getData() {
		return data;
	}

	/**
	 * Returns a double value from the double constants table.
	 * 
	 * @param index Index into the table.
	 * 
	 * @return The indexed double value.
	 */
	public Double resolveDouble(final int index) {

		if (index < 0) {
			throw new IllegalArgumentException("Index value must not be negative");
		}

		if (index >= data.getConstantPool().getDoubles().size()) {
			return null;
		}
		else {
			return data.getConstantPool().getDoubles().get(index).value();
		}
	}

	/**
	 * Returns an integer value from the integer constants table.
	 * 
	 * @param index Index into the table.
	 * 
	 * @return The indexed integer value.
	 */
	public Long resolveInteger(final int index) {

		if (index < 0) {
			throw new IllegalArgumentException("Index value must not be negative");
		}

		if (index >= data.getConstantPool().getIntegers().size()) {
			return null;
		}
		else {
			return data.getConstantPool().getIntegers().get(index).value();
		}
	}

	/**
	 * Returns a multiname value from the multiname constants table.
	 * 
	 * @param index Index into the table.
	 * 
	 * @return The indexed multiname value.
	 */
	public String[] resolveMultiname(final int index) {

		if (index < 0) {
			throw new IllegalArgumentException("Index value must not be negative");
		}

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

	/**
	 * Returns a string value from the string constants table.
	 * 
	 * @param index Index into the table.
	 * 
	 * @return The indexed string value.
	 */
	public String resolveString(final int index) {

		if (index < 0) {
			throw new IllegalArgumentException("Index value must not be negative");
		}

		if (index >= data.getConstantPool().getStrings().size()) {
			return null;
		}
		else {
			return data.getConstantPool().getStrings().get(index).getName().value();
		}
	}

	/**
	 * Returns an unsigned integer value from the unsigned integer constants table.
	 * 
	 * @param index Index into the table.
	 * 
	 * @return The indexed unsigned integer value.
	 */
	public Long resolveUInteger(final int index) {

		if (index < 0) {
			throw new IllegalArgumentException("Index value must not be negative");
		}

		if (index >= data.getConstantPool().getUintegers().size()) {
			return null;
		}
		else {
			return data.getConstantPool().getUintegers().get(index).value();
		}
	}
}