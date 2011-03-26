package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.EncodedS32;
import tv.porst.swfretools.parser.structures.EncodedS32List;

public class FlashEncodedS32ListNode extends FlashTreeNode<EncodedS32List> {

	public FlashEncodedS32ListNode(final String name, final EncodedS32List encodedList) {
		super(name, encodedList);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final EncodedS32 shape: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), shape);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : s32[%d]", getName(), getUserObject().size());
	}
}
