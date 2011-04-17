package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.FilterList;

public class FlashFilterListNode extends FlashTreeNode<FilterList> {

	public FlashFilterListNode(final String name, final FilterList filterList) {
		super(name, filterList);

		createChildren();
	}

	private void createChildren() {
		addNode("NumberOfFilters", getUserObject().getNumberOfFilters());
		addNode("Filters", getUserObject().getFilters());
	}

	@Override
	public String toString() {
		return String.format("%s : FILTERLIST", getName());
	}
}