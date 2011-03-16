package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.TextRecord2;
import tv.porst.swfretools.parser.structures.TextRecord2List;

public class FlashTextRecord2ListNode extends FlashTreeNode<TextRecord2List> {

	public FlashTextRecord2ListNode(final String name, final TextRecord2List list) {
		super(name, list);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final TextRecord2 textRecord : getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), textRecord);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : TEXTRECORDLIST", getName());
	}
}
