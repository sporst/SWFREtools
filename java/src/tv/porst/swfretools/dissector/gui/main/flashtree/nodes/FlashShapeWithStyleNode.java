package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ShapeWithStyle;

/**
 * Node that represents a ShapeWithStyle object in the Flash tree.
 */
public final class FlashShapeWithStyleNode extends FlashTreeNode<ShapeWithStyle> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashShapeWithStyleNode(final String name, final ShapeWithStyle value) {
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