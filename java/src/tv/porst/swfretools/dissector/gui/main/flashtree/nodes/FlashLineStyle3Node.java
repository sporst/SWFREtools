package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.LineStyle3;

/**
 * Node that represents a LineStyle3 object in the Flash tree.
 */
public final class FlashLineStyle3Node extends FlashTreeNode<LineStyle3> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashLineStyle3Node(final String name, final LineStyle3 value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("Width", getUserObject().getWidth());
		addNode("Color", getUserObject().getColor());
	}

	@Override
	public String toString() {
		return String.format("%s : LINESTYLE", getName());
	}
}