package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.swfretools.parser.actions.as3.AS3InstructionList;

public class AS3Code implements IFileElement {

	private final AS3InstructionList instructions;

	public AS3Code(final AS3InstructionList instructions) {
		this.instructions = instructions;
	}

	@Override
	public int getBitLength() {
		return instructions.getBitLength();
	}

	@Override
	public int getBitPosition() {
		return instructions.getBitPosition();
	}

}
