package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.BlurFilter;

/**
 * Node that represents a BlurFilter object in the Flash tree.
 */
public final class FlashBlurFilterNode extends FlashTreeNode<BlurFilter> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashBlurFilterNode(final String name, final BlurFilter value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
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