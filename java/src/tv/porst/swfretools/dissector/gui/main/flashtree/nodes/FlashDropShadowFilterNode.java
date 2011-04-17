package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.DropShadowFilter;

/**
 * Node that represents a DropShadowFilter object in the Flash tree.
 */
public final class FlashDropShadowFilterNode extends FlashTreeNode<DropShadowFilter> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashDropShadowFilterNode(final String name, final DropShadowFilter value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
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