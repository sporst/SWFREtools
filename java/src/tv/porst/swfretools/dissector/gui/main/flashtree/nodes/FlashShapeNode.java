package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.Shape;

public class FlashShapeNode extends FlashTreeNode<Shape> {

	public FlashShapeNode(final String name, final Shape shape) {
		super(name, shape);

		createChildren();
	}

	private void createChildren() {
		addNode("NumFillBits", getUserObject().getNumFillBits());
		addNode("NumLineBits", getUserObject().getNumLineBits());
		addNode("ShapeRecord", getUserObject().getShapeRecord());
	}

	@Override
	public String toString() {
		return String.format("%s : SHAPE", getName());
	}
}
