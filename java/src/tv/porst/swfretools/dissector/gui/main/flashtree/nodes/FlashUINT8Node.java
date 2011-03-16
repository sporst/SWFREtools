package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;

public class FlashUINT8Node extends FlashTreeNode<UINT8> {

	public FlashUINT8Node(final String name, final UINT8 userObject) {
		super(name, userObject);
	}

	@Override
	public String toString() {
		return String.format("%s : UINT8 (%d)", getName(), getUserObject().value());
	}
}
