package tv.porst.swfretools.parser.actions.as3;

import tv.porst.splib.binaryparser.UINT32;
import tv.porst.splib.binaryparser.UINT8;

public class AS3Hasnext2 extends AS3Instruction {

	public AS3Hasnext2(final UINT8 opcode, final UINT32 objectReg, final UINT32 indexReg) {
		super(opcode);
	}

}
