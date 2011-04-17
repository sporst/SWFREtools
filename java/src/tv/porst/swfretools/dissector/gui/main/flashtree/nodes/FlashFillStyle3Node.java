package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.FillStyle3;

public class FlashFillStyle3Node extends FlashTreeNode<FillStyle3> {

	public FlashFillStyle3Node(final String name, final FillStyle3 fillStyle) {
		super(name, fillStyle);

		createChildren();
	}

	private void createChildren() {
		addNode("FillStyleType", getUserObject().getFillStyleType());
		addNode("Color", getUserObject().getColor());
		addNode("GradientMatrix", getUserObject().getGradientMatrix());
		addNode("Gradient", getUserObject().getGradient());
		addNode("BitmapID", getUserObject().getBitmapId());
		addNode("BitmapMatrix", getUserObject().getBitmapMatrix());
	}

	@Override
	public String toString() {
		return String.format("%s : FILLSTYLE", getName());
	}
}
