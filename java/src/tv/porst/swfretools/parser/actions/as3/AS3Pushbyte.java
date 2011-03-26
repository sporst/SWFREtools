package tv.porst.swfretools.parser.actions.as3;

import tv.porst.splib.binaryparser.UINT8;

public class AS3Pushbyte extends AS3Instruction {

	public AS3Pushbyte(final UINT8 opcode, final UINT8 byteValue) {
		super(opcode);
	}

}
