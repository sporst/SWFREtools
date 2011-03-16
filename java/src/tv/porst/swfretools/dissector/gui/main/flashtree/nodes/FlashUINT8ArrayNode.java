package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;

public class FlashUINT8ArrayNode extends FlashTreeNode<UINT8[]> {

	public FlashUINT8ArrayNode(final String name, final UINT8[] integers) {
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
