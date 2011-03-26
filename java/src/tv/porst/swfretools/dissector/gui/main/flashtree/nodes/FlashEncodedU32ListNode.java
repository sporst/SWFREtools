package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.EncodedU32;
import tv.porst.swfretools.parser.structures.EncodedU32List;

public class FlashEncodedU32ListNode extends FlashTreeNode<EncodedU32List> {

	public FlashEncodedU32ListNode(final String name, final EncodedU32List encodedList) {
		super(name, encodedList);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final EncodedU32 element: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), element);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : u32[%d]", getName(), getUserObject().size());
	}
}
