package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.Rect;

/**
 * Node that represents a Rect object in the Flash tree.
 */
public final class FlashRectNode extends FlashTreeNode<Rect> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashRectNode(final String name, final Rect value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("NBits", getUserObject().getnBits());
		addNode("XMin", getUserObject().getxMin());
		addNode("XMax", getUserObject().getxMax());
		addNode("YMin", getUserObject().getyMin());
		addNode("YMax", getUserObject().getyMax());
	}

	@Override
	public String toString() {
		return String.format("%s : RECT", getName());
	}
}