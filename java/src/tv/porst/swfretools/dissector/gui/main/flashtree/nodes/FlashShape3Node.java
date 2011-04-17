package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.Shape3;

public class FlashShape3Node extends FlashTreeNode<Shape3> {

	public FlashShape3Node(final String name, final Shape3 shape) {
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
