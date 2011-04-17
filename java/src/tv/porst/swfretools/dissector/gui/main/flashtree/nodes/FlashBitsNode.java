package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.Bits;

public class FlashBitsNode extends FlashTreeNode<Bits> {

	public FlashBitsNode(final String name, final Bits bits) {
		super(name, bits);
	}

	@Override
	public String toString() {
		return String.format("%s : UBITS (%d)", getName(), getUserObject().value());
	}
}
