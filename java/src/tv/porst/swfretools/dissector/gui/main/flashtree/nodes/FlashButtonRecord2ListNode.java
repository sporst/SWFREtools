package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ButtonRecord2;
import tv.porst.swfretools.parser.structures.ButtonRecord2List;

public class FlashButtonRecord2ListNode extends FlashTreeNode<ButtonRecord2List> {

	public FlashButtonRecord2ListNode(final String name, final ButtonRecord2List buttonRecordList) {
		super(name, buttonRecordList);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final ButtonRecord2 buttonRecord: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), buttonRecord);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : BUTTONRECORDLIST", getName());
	}
}