package tv.porst.swfretools.parser.actions.as3;

import tv.porst.splib.binaryparser.UINT8;

/**
 * Parses ActionScript 3 'negatei' instructions.
 */
public final class AS3Negatei extends AS3SimpleInstruction {

	public AS3Negatei(final UINT8 opcode) {
		super(opcode);
	}

}
