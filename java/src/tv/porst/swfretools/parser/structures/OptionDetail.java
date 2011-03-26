package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;

public class OptionDetail implements IFileElement {

	private final EncodedU30 val;
	private final UINT8 kind;

	public OptionDetail(final EncodedU30 val, final UINT8 kind) {
		this.val = val;
		this.kind = kind;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(val, kind);
	}

	@Override
	public int getBitPosition() {
		return val.getBitPosition();
	}

}
