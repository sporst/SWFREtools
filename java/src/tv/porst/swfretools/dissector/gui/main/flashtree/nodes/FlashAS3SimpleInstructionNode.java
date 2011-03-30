package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.actions.as3.AS3SimpleInstruction;

public class FlashAS3SimpleInstructionNode extends FlashTreeNode<AS3SimpleInstruction> {

	public FlashAS3SimpleInstructionNode(final String name, final AS3SimpleInstruction instruction) {
		super(name, instruction);

		createChildren();
	}

	private void createChildren() {
		addNode("opcode", getUserObject().getOpcode());
	}

	@Override
	public String toString() {
		return String.format("%s", getName());
	}
}
