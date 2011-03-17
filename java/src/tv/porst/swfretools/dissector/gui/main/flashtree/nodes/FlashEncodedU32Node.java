package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.EncodedU32;

public class FlashEncodedU32Node extends FlashTreeNode<EncodedU32> {

	public FlashEncodedU32Node(final String name, final EncodedU32 userObject) {
		super(name, userObject);
	}

	@Override
	public String toString() {
		return String.format("%s : EncodedU32 (%d)", getName(), getUserObject().value());
	}
}
