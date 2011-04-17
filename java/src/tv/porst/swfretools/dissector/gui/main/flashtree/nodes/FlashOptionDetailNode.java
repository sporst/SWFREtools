package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.OptionDetail;

/**
 * Node that represents a OptionDetail object in the Flash tree.
 */
public final class FlashOptionDetailNode extends FlashTreeNode<OptionDetail> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashOptionDetailNode(final String name, final OptionDetail value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("Val", getUserObject().getVal());
		addNode("Kind", getUserObject().getKind());
	}

	@Override
	public String toString() {
		return String.format("%s : option_detail", getName());
	}
}