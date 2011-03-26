package tv.porst.swfretools.parser.structures;

import tv.porst.swfretools.parser.SWFParserHelpers;

public class TraitMethod implements ITraitKind {

	private final EncodedU30 dispId;
	private final EncodedU30 method;

	public TraitMethod(final EncodedU30 dispId, final EncodedU30 method) {
		this.dispId = dispId;
		this.method = method;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(dispId, method);
	}

	@Override
	public int getBitPosition() {
		return dispId.getBitPosition();
	}

}
