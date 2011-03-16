package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.Filter;

public class FlashFilterNode extends FlashTreeNode<Filter> {

	public FlashFilterNode(final String name, final Filter filter) {
		super(name, filter);

		createChildren();
	}

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
