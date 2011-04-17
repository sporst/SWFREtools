package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.BlurFilter;

public class FlashBlurFilterNode extends FlashTreeNode<BlurFilter> {

	public FlashBlurFilterNode(final String name, final BlurFilter filter) {
		super(name, filter);

		createChildren();
	}

	private void createChildren() {
		addNode("BlurX", getUserObject().getBlurX());
		addNode("BlurY", getUserObject().getBlurY());
		addNode("Passes", getUserObject().getPasses());
		addNode("Reserved", getUserObject().getReserved());
	}

	@Override
	public String toString() {
		return String.format("%s : BLURFILTER", getName());
	}
}
