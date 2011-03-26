package tv.porst.swfretools.parser.actions.as3;

import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;
import tv.porst.swfretools.parser.structures.EncodedU30;

public class AS3Newarray extends AS3Instruction {

	private final EncodedU30 argCount;

	public AS3Newarray(final UINT8 opcode, final EncodedU30 argCount) {
		super(opcode);

		this.argCount = argCount;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(getOpcode(), argCount);
	}

}
