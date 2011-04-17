package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ShapeWithStyle4;

/**
 * Node that represents a ShapeWithStyle4 object in the Flash tree.
 */
public final class FlashShapeWithStyle4Node extends FlashTreeNode<ShapeWithStyle4> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashShapeWithStyle4Node(final String name, final ShapeWithStyle4 value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("FillStyles", getUserObject().getFillStyles());
		addNode("LineStyles", getUserObject().getLineStyles());
		addNode("NumFillBits", getUserObject().getNumFillBits());
		addNode("NumLineBits", getUserObject().getNumLineBits());
		addNode("ShapeRecord", getUserObject().getShapeRecord());
	}

	@Override
	public String toString() {
		return String.format("%s : SHAPEWITHSTYLE", getName());
	}
}