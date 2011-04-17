package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.Filter;

/**
 * Node that represents a Filter object in the Flash tree.
 */
public final class FlashFilterNode extends FlashTreeNode<Filter> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashFilterNode(final String name, final Filter value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("FilterID", getUserObject().getFilterId());
		addNode("DropShadowFilter", getUserObject().getDropShadowFilter());
		addNode("BlurFilter", getUserObject().getBlurFilter());
		addNode("GlowFilter", getUserObject().getGlowFilter());
		addNode("BevelFilter", getUserObject().getBevelFilter());
		addNode("GradientGlowFilter", getUserObject().getGradientGlowFilter());
		addNode("ConvolutionFilter", getUserObject().getConvolutionFilter());
		addNode("ColorMatrixFilter", getUserObject().getColorMatrixFilter());
		addNode("GradientBevelFilter", getUserObject().getGradientBevelFilter());
	}

	@Override
	public String toString() {
		return String.format("%s : FILTER", getName());
	}
}