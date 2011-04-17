package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.MorphFillStyle;

/**
 * Node that represents a MorphFillStyle object in the Flash tree.
 */
public final class FlashMorphFillStyleNode extends FlashTreeNode<MorphFillStyle> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashMorphFillStyleNode(final String name, final MorphFillStyle value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("FillStyleType", getUserObject().getFillStyleType());
		addNode("StartColor", getUserObject().getStartColor());
		addNode("EndColor", getUserObject().getEndColor());
		addNode("StartGradientMatrix", getUserObject().getStartGradientMatrix());
		addNode("EndGradientMatrix", getUserObject().getEndGradientMatrix());
		addNode("Gradient", getUserObject().getGradient());
		addNode("BitmapID", getUserObject().getBitmapId());
		addNode("StartBitmapMatrix", getUserObject().getStartBitmapMatrix());
		addNode("EndBitmapMatrix", getUserObject().getEndBitmapMatrix());
	}

	@Override
	public String toString() {
		return String.format("%s : MORPHFILLSTYLE", getName());
	}
}