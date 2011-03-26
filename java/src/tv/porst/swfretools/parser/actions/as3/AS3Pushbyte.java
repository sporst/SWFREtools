package tv.porst.swfretools.parser.actions.as3;

import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;

public class AS3Pushbyte extends AS3Instruction {

	private final UINT8 byteValue;

	public AS3Pushbyte(final UINT8 opcode, final UINT8 byteValue) {
		super(opcode);

		this.byteValue = byteValue;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(getOpcode(), byteValue);
	}

}
