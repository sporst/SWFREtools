package tv.porst.swfretools.parser.actions.as3;

import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;
import tv.porst.swfretools.parser.structures.EncodedU30;

public class AS3Debugline extends AS3Instruction {

	private final EncodedU30 lineNum;

	public AS3Debugline(final UINT8 opcode, final EncodedU30 lineNum) {
		super(opcode);

		this.lineNum = lineNum;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(getOpcode(), lineNum);
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public EncodedU30 getLineNum() {
		return lineNum;
	}

}
