package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.UINT32;

public class FlashUINT32Node extends FlashTreeNode<UINT32> {

	public FlashUINT32Node(final String name, final UINT32 userObject) {
		super(name, userObject);
	}

	@Override
	public String toString() {
		return String.format("%s : UINT32 (%d)", getName(), getUserObject().value());
	}
}
