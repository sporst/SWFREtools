package tv.porst.swfretools.parser.structures;

import tv.porst.swfretools.parser.SWFParserHelpers;

public class GenericVector implements IMultiname {

	private final EncodedU30 typeDefinition;
	private final EncodedU30 paramCount;
	private final EncodedU30List params;

	public GenericVector(final EncodedU30 typeDefinition, final EncodedU30 paramCount, final EncodedU30List params) {
		this.typeDefinition = typeDefinition;
		this.paramCount = paramCount;
		this.params = params;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(typeDefinition, paramCount, params);
	}

	@Override
	public int getBitPosition() {
		return typeDefinition.getBitPosition();
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public EncodedU30 getParamCount() {
		return paramCount;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public EncodedU30List getParams() {
		return params;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public EncodedU30 getTypeDefinition() {
		return typeDefinition;
	}
}
