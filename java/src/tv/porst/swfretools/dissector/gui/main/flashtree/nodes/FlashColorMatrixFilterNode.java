package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ColorMatrixFilter;

/**
 * Node that represents a ColorMatrixFilter object in the Flash tree.
 */
public final class FlashColorMatrixFilterNode extends FlashTreeNode<ColorMatrixFilter> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashColorMatrixFilterNode(final String name, final ColorMatrixFilter value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("Matrix", getUserObject().getMatrix());
	}

	@Override
	public String toString() {
		return String.format("%s : COLORMATRIXFILTER", getName());
	}
}