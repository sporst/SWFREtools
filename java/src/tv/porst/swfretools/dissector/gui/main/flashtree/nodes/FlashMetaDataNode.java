package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.MetaData;

public class FlashMetaDataNode extends FlashTreeNode<MetaData> {

	public FlashMetaDataNode(final String name, final MetaData metaData) {
		super(name, metaData);

		createChildren();
	}

	private void createChildren() {
		addNode("Name", getUserObject().getName());
		addNode("ItemCount", getUserObject().getItemCount());
		addNode("Items", getUserObject().getItems());
	}

	@Override
	public String toString() {
		return String.format("%s : meta_data", getName());
	}
}
