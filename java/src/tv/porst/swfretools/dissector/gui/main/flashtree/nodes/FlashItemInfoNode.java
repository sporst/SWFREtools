package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ItemInfo;

/**
 * Node that represents a ItemInfo object in the Flash tree.
 */
public final class FlashItemInfoNode extends FlashTreeNode<ItemInfo> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashItemInfoNode(final String name, final ItemInfo value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("HasAddTerms", getUserObject().getKey());
		addNode("HasMultTerms", getUserObject().getValue());
	}

	@Override
	public String toString() {
		return String.format("%s : item_info", getName());
	}
}