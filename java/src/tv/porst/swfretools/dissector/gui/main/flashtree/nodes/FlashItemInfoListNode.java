package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.ItemInfo;
import tv.porst.swfretools.parser.structures.ItemInfoList;

public class FlashItemInfoListNode extends FlashTreeNode<ItemInfoList> {

	public FlashItemInfoListNode(final String name, final ItemInfoList encodedList) {
		super(name, encodedList);

		createChildren();
	}

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
