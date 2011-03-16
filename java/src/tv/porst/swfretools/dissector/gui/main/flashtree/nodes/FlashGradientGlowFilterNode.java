package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.GradientGlowFilter;

public class FlashGradientGlowFilterNode extends FlashTreeNode<GradientGlowFilter> {

	public FlashGradientGlowFilterNode(final String name, final GradientGlowFilter filter) {
		super(name, filter);

		createChildren();
	}

	private void createChildren() {
		addNode("NumColors", getUserObject().getNumColors());
		addNode("GradientColors", getUserObject().getGradientColors());
		addNode("GradientRatio", getUserObject().getGradientRatio());
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
		return String.format("%s : GRADIENTGLOWFILTER", getName());
	}
}
