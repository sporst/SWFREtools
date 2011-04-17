package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.GradRecord;
import tv.porst.swfretools.parser.structures.GradRecordList;

public class FlashGradRecordListNode extends FlashTreeNode<GradRecordList> {

	public FlashGradRecordListNode(final String name, final GradRecordList gradRecordList) {
		super(name, gradRecordList);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final GradRecord gradRecord: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), gradRecord);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : GRADRECORDLIST", getName());
	}
}