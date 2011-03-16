package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.ByteArray;

public class FlashByteArrayNode extends FlashTreeNode<ByteArray> {

	public FlashByteArrayNode(final String name, final ByteArray userObject) {
		super(name, userObject);
	}

	@Override
	public String toString() {
		return String.format("%s : BYTEARRAY[%d]", getName(), getUserObject().getValue().length);
	}
}
