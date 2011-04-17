package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.structures.UINT8List;

public class FlashUINT8ListNode extends FlashTreeNode<UINT8List> {

	public FlashUINT8ListNode(final String name, final UINT8List integers) {
		super(name, integers);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final UINT8 integer: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), integer);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : UINT8ARRAY", getName());
	}
}
