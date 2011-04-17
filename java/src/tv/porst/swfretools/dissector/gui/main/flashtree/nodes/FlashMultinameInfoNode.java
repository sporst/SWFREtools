package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.MultinameInfo;

/**
 * Node that represents a MultinameInfo object in the Flash tree.
 */
public final class FlashMultinameInfoNode extends FlashTreeNode<MultinameInfo> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashMultinameInfoNode(final String name, final MultinameInfo value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("Kind", getUserObject().getKind());
		addNode("Data", getUserObject().getData());
	}

	@Override
	public String toString() {
		return String.format("%s : multiname_info", getName());
	}
}