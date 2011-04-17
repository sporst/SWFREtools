package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.BevelFilter;

/**
 * Node that represents a BevelFilter object in the Flash tree.
 */
public final class FlashBevelFilterNode extends FlashTreeNode<BevelFilter> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashBevelFilterNode(final String name, final BevelFilter value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
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