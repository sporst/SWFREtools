package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.Filter;
import tv.porst.swfretools.parser.structures.SingleFilterList;

public class FlashSingleFilterListNode extends FlashTreeNode<SingleFilterList> {

	public FlashSingleFilterListNode(final String name, final SingleFilterList singleFilterList) {
		super(name, singleFilterList);

		createChildren();
	}

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