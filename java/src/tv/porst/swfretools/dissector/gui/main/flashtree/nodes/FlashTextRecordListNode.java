package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.TextRecord;
import tv.porst.swfretools.parser.structures.TextRecordList;

public class FlashTextRecordListNode extends FlashTreeNode<TextRecordList> {

	public FlashTextRecordListNode(final String name, final TextRecordList list) {
		super(name, list);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final TextRecord textRecord : getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), textRecord);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : TEXTRECORDLIST", getName());
	}
}
