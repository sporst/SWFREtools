package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.BevelFilter;

public class FlashBevelFilterNode extends FlashTreeNode<BevelFilter> {

	public FlashBevelFilterNode(final String name, final BevelFilter filter) {
		super(name, filter);

		createChildren();
	}

	private void createChildren() {
		addNode("ShadowColor", getUserObject().getShadowColor());
		addNode("HighlightColor", getUserObject().getHighlightColor());
		addNode("BlurX", getUserObject().getBlurX());
		addNode("BlurY", getUserObject().getBlurY());
		addNode("Angle", getUserObject().getAngle());
		addNode("Distance", getUserObject().getDistance());
		addNode("Strength", getUserObject().getStrength());
		addNode("InnerShadow", getUserObject().getInnerShadow());
		addNode("Knockout", getUserObject().getKnockout());
		addNode("CompositeSource", getUserObject().getCompositeSource());
		addNode("OnTop", getUserObject().getOnTop());
		addNode("Passes", getUserObject().getPasses());
	}

	@Override
	public String toString() {
		return String.format("%s : BEVELFILTER", getName());
	}
}
