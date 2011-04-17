package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.GradRecord3;
import tv.porst.swfretools.parser.structures.GradRecord3List;

public class FlashGradRecord3ListNode extends FlashTreeNode<GradRecord3List> {

	public FlashGradRecord3ListNode(final String name, final GradRecord3List gradRecordList) {
		super(name, gradRecordList);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final GradRecord3 gradRecord: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), gradRecord);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : GRADRECORDLIST", getName());
	}
}