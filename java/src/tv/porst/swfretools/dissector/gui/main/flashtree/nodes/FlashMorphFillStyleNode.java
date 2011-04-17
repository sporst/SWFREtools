package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.MorphFillStyle;

public class FlashMorphFillStyleNode extends FlashTreeNode<MorphFillStyle> {

	public FlashMorphFillStyleNode(final String name, final MorphFillStyle fillStyle) {
		super(name, fillStyle);

		createChildren();
	}

	private void createChildren() {
		addNode("FillStyleType", getUserObject().getFillStyleType());
		addNode("StartColor", getUserObject().getStartColor());
		addNode("EndColor", getUserObject().getEndColor());
		addNode("StartGradientMatrix", getUserObject().getStartGradientMatrix());
		addNode("EndGradientMatrix", getUserObject().getEndGradientMatrix());
		addNode("Gradient", getUserObject().getGradient());
		addNode("BitmapID", getUserObject().getBitmapId());
		addNode("StartBitmapMatrix", getUserObject().getStartBitmapMatrix());
		addNode("EndBitmapMatrix", getUserObject().getEndBitmapMatrix());
	}

	@Override
	public String toString() {
		return String.format("%s : MORPHFILLSTYLE", getName());
	}
}
