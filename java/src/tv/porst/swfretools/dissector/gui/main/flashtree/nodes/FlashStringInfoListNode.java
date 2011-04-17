package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.StringInfo;
import tv.porst.swfretools.parser.structures.StringInfoList;

public class FlashStringInfoListNode extends FlashTreeNode<StringInfoList> {

	public FlashStringInfoListNode(final String name, final StringInfoList encodedList) {
		super(name, encodedList);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final StringInfo element: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), element);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : string_info[%d]", getName(), getUserObject().size());
	}
}
