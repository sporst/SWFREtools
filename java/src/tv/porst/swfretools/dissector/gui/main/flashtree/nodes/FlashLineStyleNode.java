package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.LineStyle;

/**
 * Node that represents a LineStyle object in the Flash tree.
 */
public final class FlashLineStyleNode extends FlashTreeNode<LineStyle> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashLineStyleNode(final String name, final LineStyle value) {
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