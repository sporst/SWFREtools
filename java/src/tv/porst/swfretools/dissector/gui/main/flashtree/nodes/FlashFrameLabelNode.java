package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.FrameLabel;

/**
 * Node that represents a FrameLabel object in the Flash tree.
 */
public final class FlashFrameLabelNode extends FlashTreeNode<FrameLabel> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashFrameLabelNode(final String name, final FrameLabel value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("Offset", getUserObject().getOffset());
		addNode("Name", getUserObject().getName());
	}

	@Override
	public String toString() {
		return String.format("%s : FRAMELABEL", getName());
	}
}