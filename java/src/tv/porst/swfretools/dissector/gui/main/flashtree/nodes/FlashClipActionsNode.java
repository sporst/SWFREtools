package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ClipActions;

/**
 * Node that represents a ClipActions object in the Flash tree.
 */
public final class FlashClipActionsNode extends FlashTreeNode<ClipActions> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashClipActionsNode(final String name, final ClipActions value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("Ratio", getUserObject().getReserved());
		addNode("AllEventFlags", getUserObject().getAllEventFlags());
		addNode("ClipActionRecords", getUserObject().getClipActionRecords());
		addNode("ClipActionEndFlag", getUserObject().getClipActionEndFlag());
	}

	@Override
	public String toString() {
		return String.format("%s : GRADRECORD", getName());
	}
}