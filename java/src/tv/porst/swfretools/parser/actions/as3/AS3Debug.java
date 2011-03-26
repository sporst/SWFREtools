package tv.porst.swfretools.parser.actions.as3;

import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.structures.EncodedU30;

public class AS3Debug extends AS3Instruction {

	public AS3Debug(final UINT8 opcode, final UINT8 debugType, final EncodedU30 index, final UINT8 reg, final EncodedU30 extra) {
		super(opcode);
	}

}
