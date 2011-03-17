package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.ButtonRecord;
import tv.porst.swfretools.parser.structures.ButtonRecordList;

public class FlashButtonRecordListNode extends FlashTreeNode<ButtonRecordList> {

	public FlashButtonRecordListNode(final String name, final ButtonRecordList buttonRecordList) {
		super(name, buttonRecordList);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final ButtonRecord buttonRecord: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), buttonRecord);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : BUTTONRECORDLIST", getName());
	}
}