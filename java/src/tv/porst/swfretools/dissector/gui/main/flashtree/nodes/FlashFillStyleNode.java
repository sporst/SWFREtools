package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.FillStyle;

public class FlashFillStyleNode extends FlashTreeNode<FillStyle> {

	public FlashFillStyleNode(final String name, final FillStyle fillStyle) {
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
