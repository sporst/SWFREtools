package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ShapeWithStyle3;

/**
 * Node that represents a ShapeWithStyle3 object in the Flash tree.
 */
public final class FlashShapeWithStyle3Node extends FlashTreeNode<ShapeWithStyle3> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashShapeWithStyle3Node(final String name, final ShapeWithStyle3 value) {
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