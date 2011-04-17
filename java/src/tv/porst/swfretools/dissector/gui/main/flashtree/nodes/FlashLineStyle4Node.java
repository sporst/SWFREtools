package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.LineStyle4;

public class FlashLineStyle4Node extends FlashTreeNode<LineStyle4> {

	public FlashLineStyle4Node(final String name, final LineStyle4 lineStyle) {
		super(name, lineStyle);

		createChildren();
	}

	private void createChildren() {
		addNode("Width", getUserObject().getWidth());
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
		addNode("Color", getUserObject().getColor());
		addNode("FillType", getUserObject().getFillType());
	}

	@Override
	public String toString() {
		return String.format("%s : LINESTYLE", getName());
	}
}
