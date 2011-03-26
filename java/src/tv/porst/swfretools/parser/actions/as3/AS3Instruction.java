package tv.porst.swfretools.parser.actions.as3;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.splib.binaryparser.UINT8;

public abstract class AS3Instruction implements IFileElement {

	private final UINT8 opcode;

	public AS3Instruction(final UINT8 opcode) {
		this.opcode = opcode;
	}

	@Override
	public int getBitPosition() {
		return opcode.getBitPosition();
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public UINT8 getOpcode() {
		return opcode;
	}

}
