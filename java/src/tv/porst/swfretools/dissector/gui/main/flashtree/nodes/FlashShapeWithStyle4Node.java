package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ShapeWithStyle4;

public class FlashShapeWithStyle4Node extends FlashTreeNode<ShapeWithStyle4> {

	public FlashShapeWithStyle4Node(final String name, final ShapeWithStyle4 shapeWithStyle) {
		super(name, shapeWithStyle);

		createChildren();
	}

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
