package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;

public class FlashAsciiStringNode extends FlashTreeNode<AsciiString> {

	public FlashAsciiStringNode(final String name, final AsciiString string) {
		super(name, string);
	}

	@Override
	public String toString() {
		return String.format("%s : STRING", getName());
	}
}
