package tv.porst.swfretools.parser.actions.as3;

import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;
import tv.porst.swfretools.parser.structures.EncodedU30;

public class AS3Debug extends AS3Instruction {

	private final UINT8 debugType;
	private final EncodedU30 index;
	private final UINT8 reg;
	private final EncodedU30 extra;

	public AS3Debug(final UINT8 opcode, final UINT8 debugType, final EncodedU30 index, final UINT8 reg, final EncodedU30 extra) {
		super(opcode);

		this.debugType = debugType;
		this.index = index;
		this.reg = reg;
		this.extra = extra;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(getOpcode(), debugType, index, reg, extra);
	}

}
