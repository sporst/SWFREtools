package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.Filter;
import tv.porst.swfretools.parser.structures.SingleFilterList;

/**
 * Node that represents a SingleFilterList object in the Flash tree.
 */
public final class FlashSingleFilterListNode extends FlashTreeNode<SingleFilterList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashSingleFilterListNode(final String name, final SingleFilterList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final Filter filter: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), filter);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : SINGLEFILTERLIST", getName());
	}
}