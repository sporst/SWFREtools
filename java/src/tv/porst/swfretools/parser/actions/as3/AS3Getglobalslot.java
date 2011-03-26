package tv.porst.swfretools.parser.actions.as3;

import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.structures.EncodedU30;

public class AS3Getglobalslot extends AS3Instruction {

	public AS3Getglobalslot(final UINT8 opcode, final EncodedU30 slotIndex) {
		super(opcode);
	}

}
