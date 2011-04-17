package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.FilterList;

/**
 * Node that represents a FilterList object in the Flash tree.
 */
public final class FlashFilterListNode extends FlashTreeNode<FilterList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashFilterListNode(final String name, final FilterList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("NumberOfFilters", getUserObject().getNumberOfFilters());
		addNode("Filters", getUserObject().getFilters());
	}

	@Override
	public String toString() {
		return String.format("%s : FILTERLIST", getName());
	}
}