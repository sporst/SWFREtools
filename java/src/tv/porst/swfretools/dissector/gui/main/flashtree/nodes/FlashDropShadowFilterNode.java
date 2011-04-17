package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.DropShadowFilter;

public class FlashDropShadowFilterNode extends FlashTreeNode<DropShadowFilter> {

	public FlashDropShadowFilterNode(final String name, final DropShadowFilter filter) {
		super(name, filter);

		createChildren();
	}

	private void createChildren() {
		addNode("DropShadowColor", getUserObject().getDropShadowColor());
		addNode("BlurX", getUserObject().getBlurX());
		addNode("BlurY", getUserObject().getBlurY());
		addNode("Angle", getUserObject().getAngle());
		addNode("Distance", getUserObject().getDistance());
		addNode("Strength", getUserObject().getStrength());
		addNode("InnerShadow", getUserObject().getInnerShadow());
		addNode("Knockout", getUserObject().getKnockout());
		addNode("CompositeSource", getUserObject().getCompositeSource());
		addNode("Passes", getUserObject().getPasses());
	}

	@Override
	public String toString() {
		return String.format("%s : DROPSHADOWFILTER", getName());
	}
}
