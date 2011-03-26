package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.ItemInfo;

public class FlashItemInfoNode extends FlashTreeNode<ItemInfo> {

	public FlashItemInfoNode(final String name, final ItemInfo itemInfo) {
		super(name, itemInfo);

		createChildren();
	}

	private void createChildren() {
		addNode("HasAddTerms", getUserObject().getKey());
		addNode("HasMultTerms", getUserObject().getValue());
	}

	@Override
	public String toString() {
		return String.format("%s : item_info", getName());
	}
}
