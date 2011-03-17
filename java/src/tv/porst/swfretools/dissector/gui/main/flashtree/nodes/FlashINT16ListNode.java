package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.INT16;
import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.INT16List;

public class FlashINT16ListNode extends FlashTreeNode<INT16List> {

	public FlashINT16ListNode(final String name, final INT16List userObject) {
		super(name, userObject);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final INT16 element : getUserObject()) {
			addNode(String.format("%s[%d]", getName(), counter), element);
			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : INT16[%d]", getName(), getUserObject().size());
	}
}
