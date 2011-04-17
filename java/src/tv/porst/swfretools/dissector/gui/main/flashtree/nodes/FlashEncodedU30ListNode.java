package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.EncodedU30;
import tv.porst.swfretools.parser.structures.EncodedU30List;

public class FlashEncodedU30ListNode extends FlashTreeNode<EncodedU30List> {

	public FlashEncodedU30ListNode(final String name, final EncodedU30List encodedList) {
		super(name, encodedList);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final EncodedU30 element: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), element);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : u30[%d]", getName(), getUserObject().size());
	}
}
