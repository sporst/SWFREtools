package tv.porst.swfretools.parser.actions.as3;

import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;
import tv.porst.swfretools.parser.structures.EncodedS24;
import tv.porst.swfretools.parser.structures.EncodedU30;

public class AS3Lookupswitch extends AS3Instruction {

	private final EncodedS24 defaultOffset;
	private final EncodedU30 caseCounts;
	private final EncodedS24List offsets;

	public AS3Lookupswitch(final UINT8 opcode, final EncodedS24 defaultOffset, final EncodedU30 caseCounts, final EncodedS24List offsets) {
		super(opcode);

		this.defaultOffset = defaultOffset;
		this.caseCounts = caseCounts;
		this.offsets = offsets;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(getOpcode(), defaultOffset, caseCounts, offsets);
	}

}
