package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.UINT16;

public class FlashUINT16Node extends FlashTreeNode<UINT16> {

	public FlashUINT16Node(final String name, final UINT16 userObject) {
		super(name, userObject);
	}

	@Override
	public String toString() {
		return String.format("%s : UINT16 (%d)", getName(), getUserObject().value());
	}
}
