package tv.porst.swfretools.parser.actions.as3;

import tv.porst.splib.binaryparser.UINT8;

public abstract class AS3SimpleInstruction extends AS3Instruction {

	public AS3SimpleInstruction(final UINT8 opcode) {
		super(opcode);
	}

	@Override
	public int getBitLength() {
		return getOpcode().getBitPosition();
	}

}
