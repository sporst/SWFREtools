package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.GradientBevelFilter;

/**
 * Node that represents a GradientBevelFilter object in the Flash tree.
 */
public final class FlashGradientBevelFilterNode extends FlashTreeNode<GradientBevelFilter> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashGradientBevelFilterNode(final String name, final GradientBevelFilter value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
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
		return String.format("%s : GRADIENTBEVELFILTER", getName());
	}
}