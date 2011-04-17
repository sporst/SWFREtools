package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.UBits;

public class FlashUBitsNode extends FlashTreeNode<UBits> {

	public FlashUBitsNode(final String name, final UBits bits) {
		super(name, bits);
	}

	@Override
	public String toString() {
		return String.format("%s : UBITS (%d)", getName(), getUserObject().value());
	}
}
