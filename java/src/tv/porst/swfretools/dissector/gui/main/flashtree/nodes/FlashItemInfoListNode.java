package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ItemInfo;
import tv.porst.swfretools.parser.structures.ItemInfoList;

/**
 * Node that represents a ItemInfoList object in the Flash tree.
 */
public final class FlashItemInfoListNode extends FlashTreeNode<ItemInfoList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashItemInfoListNode(final String name, final ItemInfoList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final ItemInfo element: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), element);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : item_info[%d]", getName(), getUserObject().size());
	}
}