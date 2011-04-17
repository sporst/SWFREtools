package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.GradRecord3;

/**
 * Node that represents a GradRecord3 object in the Flash tree.
 */
public final class FlashGradRecord3Node extends FlashTreeNode<GradRecord3> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashGradRecord3Node(final String name, final GradRecord3 value) {
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