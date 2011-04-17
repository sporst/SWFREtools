package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.EncodedS32;

public class FlashEncodedS32Node extends FlashTreeNode<EncodedS32> {

	public FlashEncodedS32Node(final String name, final EncodedS32 userObject) {
		super(name, userObject);
	}

	@Override
	public String toString() {
		return String.format("%s : s32 (%d)", getName(), getUserObject().value());
	}
}
