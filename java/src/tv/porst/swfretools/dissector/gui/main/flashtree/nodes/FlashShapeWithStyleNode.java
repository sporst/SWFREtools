package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.ShapeWithStyle;

public class FlashShapeWithStyleNode extends FlashTreeNode<ShapeWithStyle> {

	public FlashShapeWithStyleNode(final String name, final ShapeWithStyle shapeWithStyle) {
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
