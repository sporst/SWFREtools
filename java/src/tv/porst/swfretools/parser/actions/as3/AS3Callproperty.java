package tv.porst.swfretools.parser.actions.as3;

import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;
import tv.porst.swfretools.parser.structures.EncodedU30;

public class AS3Callproperty extends AS3Instruction {

	private final EncodedU30 index;

	private final EncodedU30 argCount;

	public AS3Callproperty(final UINT8 opcode, final EncodedU30 index, final EncodedU30 argCount) {
		super(opcode);

		this.index = index;
		this.argCount = argCount;
	}
	/**
	 * Returns the
	 *
	 * @return The
	 */
	public EncodedU30 getArgCount() {
		return argCount;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(getOpcode(), index, argCount);
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public EncodedU30 getIndex() {
		return index;
	}

}
