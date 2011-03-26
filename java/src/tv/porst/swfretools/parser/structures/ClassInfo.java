package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.swfretools.parser.SWFParserHelpers;

public class ClassInfo implements IFileElement {

	private final EncodedU30 cInit;
	private final EncodedU30 traitCount;
	private final TraitsInfoList traits;

	public ClassInfo(final EncodedU30 cInit, final EncodedU30 traitCount,
			final TraitsInfoList traits) {

		this.cInit = cInit;
		this.traitCount = traitCount;
		this.traits = traits;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(cInit, traitCount, traits);
	}

	@Override
	public int getBitPosition() {
		return cInit.getBitPosition();
	}

}
