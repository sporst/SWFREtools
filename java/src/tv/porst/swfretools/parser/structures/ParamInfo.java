package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.IFileElement;


public class ParamInfo implements IFileElement {

	private final EncodedU30List paramNames;

	public ParamInfo(final EncodedU30List paramNames) {
		this.paramNames = paramNames;
	}

	@Override
	public int getBitLength() {
		return paramNames.getBitLength();
	}

	@Override
	public int getBitPosition() {
		return paramNames.getBitPosition();
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public EncodedU30List getParamNames() {
		return paramNames;
	}

}
