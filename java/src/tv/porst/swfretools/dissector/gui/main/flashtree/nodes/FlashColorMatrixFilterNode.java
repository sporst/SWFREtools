package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ColorMatrixFilter;

public class FlashColorMatrixFilterNode extends FlashTreeNode<ColorMatrixFilter> {

	public FlashColorMatrixFilterNode(final String name, final ColorMatrixFilter filter) {
		super(name, filter);

		createChildren();
	}

	private void createChildren() {
		addNode("Matrix", getUserObject().getMatrix());
	}

	@Override
	public String toString() {
		return String.format("%s : COLORMATRIXFILTER", getName());
	}
}
