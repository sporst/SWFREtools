package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.KerningRecord;
import tv.porst.swfretools.parser.structures.KerningRecordList;

public class FlashKerningRecordListNode extends FlashTreeNode<KerningRecordList> {

	public FlashKerningRecordListNode(final String name, final KerningRecordList kerningRecordList) {
		super(name, kerningRecordList);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final KerningRecord symbol: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), symbol);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : KERNINGRECORDLIST", getName());
	}

}
