package tv.porst.swfretools.parser.actions.as3;

import tv.porst.splib.binaryparser.INT24;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;

public class AS3Ifle extends AS3Instruction {

	private final INT24 offset;

	public AS3Ifle(final UINT8 opcode, final INT24 offset) {
		super(opcode);

		this.offset = offset;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(getOpcode(), offset);
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public INT24 getOffset() {
		return offset;
	}

}
