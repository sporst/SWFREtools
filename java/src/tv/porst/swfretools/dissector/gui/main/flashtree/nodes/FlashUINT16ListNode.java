package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.structures.UINT16List;

public class FlashUINT16ListNode extends FlashTreeNode<UINT16List> {

	public FlashUINT16ListNode(final String name, final UINT16List userObject) {
		super(name, userObject);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final UINT16 element : getUserObject()) {
			addNode(String.format("%s[%d]", getName(), counter), element);
			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : UINT16[%d]", getName(), getUserObject().size());
	}
}
