package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.ShapeWithStyle3;

public class FlashShapeWithStyle3Node extends FlashTreeNode<ShapeWithStyle3> {

	public FlashShapeWithStyle3Node(final String name, final ShapeWithStyle3 shapeWithStyle) {
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
