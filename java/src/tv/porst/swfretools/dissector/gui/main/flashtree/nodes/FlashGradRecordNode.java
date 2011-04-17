package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.GradRecord;

/**
 * Node that represents a GradRecord object in the Flash tree.
 */
public final class FlashGradRecordNode extends FlashTreeNode<GradRecord> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashGradRecordNode(final String name, final GradRecord value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("Ratio", getUserObject().getRatio());
		addNode("Color", getUserObject().getColor());
	}

	@Override
	public String toString() {
		return String.format("%s : GRADRECORD", getName());
	}
}