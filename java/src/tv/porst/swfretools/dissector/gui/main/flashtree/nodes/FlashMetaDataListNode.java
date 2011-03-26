package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.MetaData;
import tv.porst.swfretools.parser.structures.MetaDataList;

public class FlashMetaDataListNode extends FlashTreeNode<MetaDataList> {

	public FlashMetaDataListNode(final String name, final MetaDataList encodedList) {
		super(name, encodedList);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final MetaData element: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), element);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : meta_data[%d]", getName(), getUserObject().size());
	}
}
