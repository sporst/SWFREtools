package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.GlowFilter;

public class FlashGlowFilterNode extends FlashTreeNode<GlowFilter> {

	public FlashGlowFilterNode(final String name, final GlowFilter filter) {
		super(name, filter);

		createChildren();
	}

	private void createChildren() {
		addNode("GlowColor", getUserObject().getGlowColor());
		addNode("BlurX", getUserObject().getBlurX());
		addNode("BlurY", getUserObject().getBlurY());
		addNode("Strength", getUserObject().getStrength());
		addNode("InnerShadow", getUserObject().getInnerShadow());
		addNode("Knockout", getUserObject().getKnockout());
		addNode("CompositeSource", getUserObject().getCompositeSource());
		addNode("Passes", getUserObject().getPasses());
	}

	@Override
	public String toString() {
		return String.format("%s : GLOWFILTER", getName());
	}
}
