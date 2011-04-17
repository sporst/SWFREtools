package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.MorphLineStyle2;

public class FlashMorphLineStyle2Node extends FlashTreeNode<MorphLineStyle2> {

	public FlashMorphLineStyle2Node(final String name, final MorphLineStyle2 lineStyle) {
		super(name, lineStyle);

		createChildren();
	}

	private void createChildren() {
		addNode("StartWidth", getUserObject().getStartWidth());
		addNode("EndWidth", getUserObject().getEndWidth());
		addNode("StartCapStyle", getUserObject().getStartCapStyle());
		addNode("JoinStyle", getUserObject().getJoinStyle());
		addNode("HasFillFlag", getUserObject().getHasFillFlag());
		addNode("NoHScaleFlag", getUserObject().getNoHScaleFlag());
		addNode("NoVScaleFlag", getUserObject().getNoVScaleFlag());
		addNode("PixelHintingFlag", getUserObject().getPixelHintingFlag());
		addNode("Reserved", getUserObject().getReserved());
		addNode("NoClose", getUserObject().getNoClose());
		addNode("EndCapStyle", getUserObject().getEndCapStyle());
		addNode("MiterLimitFactor", getUserObject().getMiterLimitFactor());
		addNode("StartColor", getUserObject().getStartColor());
		addNode("EndColor", getUserObject().getEndColor());
		addNode("FillType", getUserObject().getFillType());
	}

	@Override
	public String toString() {
		return String.format("%s : MORPHLINESTYLE", getName());
	}
}
