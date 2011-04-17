package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.FillStyle;

/**
 * Node that represents a FillStyle object in the Flash tree.
 */
public final class FlashFillStyleNode extends FlashTreeNode<FillStyle> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashFillStyleNode(final String name, final FillStyle value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("FillStyleType", getUserObject().getFillStyleType());
		addNode("Color", getUserObject().getColor());
		addNode("GradientMatrix", getUserObject().getGradientMatrix());
		addNode("Gradient", getUserObject().getGradient());
		addNode("BitmapID", getUserObject().getBitmapId());
		addNode("BitmapMatrix", getUserObject().getBitmapMatrix());
	}

	@Override
	public String toString() {
		return String.format("%s : FILLSTYLE", getName());
	}
}