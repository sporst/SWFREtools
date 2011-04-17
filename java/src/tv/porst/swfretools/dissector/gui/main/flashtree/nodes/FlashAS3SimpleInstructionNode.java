package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.actions.as3.AS3SimpleInstruction;

/**
 * Node that represents a simple AS3 instruction object in the Flash tree.
 */
public final class FlashAS3SimpleInstructionNode extends FlashTreeNode<AS3SimpleInstruction> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashAS3SimpleInstructionNode(final String name, final AS3SimpleInstruction value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("opcode", getUserObject().getOpcode());
	}

	@Override
	public String toString() {
		return String.format("%s", getName());
	}
}