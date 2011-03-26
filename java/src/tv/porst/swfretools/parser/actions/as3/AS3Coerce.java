package tv.porst.swfretools.parser.actions.as3;

import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;
import tv.porst.swfretools.parser.structures.EncodedU30;

public class AS3Coerce extends AS3Instruction {

	private final EncodedU30 index;

	public AS3Coerce(final UINT8 opcode, final EncodedU30 index) {
		super(opcode);

		this.index = index;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(getOpcode(), index);
	}

}
