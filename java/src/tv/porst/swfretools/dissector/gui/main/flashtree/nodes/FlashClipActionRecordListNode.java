package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.ClipActionRecord;
import tv.porst.swfretools.parser.structures.ClipActionRecordList;

public class FlashClipActionRecordListNode extends FlashTreeNode<ClipActionRecordList> {

	public FlashClipActionRecordListNode(final String name, final ClipActionRecordList clipActionRecordList) {
		super(name, clipActionRecordList);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final ClipActionRecord clipActionRecord: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), clipActionRecord);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : CLIPACTIONRECORDLIST", getName());
	}

}
