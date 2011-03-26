package tv.porst.swfretools.parser.actions.as3;

import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.structures.EncodedS24;
import tv.porst.swfretools.parser.structures.EncodedU30;

public class AS3Lookupswitch extends AS3Instruction {

	public AS3Lookupswitch(final UINT8 opcode, final EncodedS24 defaultOffset, final EncodedU30 caseCounts, final EncodedS24List encodedS24List) {
		super(opcode);
	}

}
