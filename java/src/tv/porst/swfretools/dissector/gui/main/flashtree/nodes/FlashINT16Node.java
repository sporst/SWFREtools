package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.INT16;
import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;

public class FlashINT16Node extends FlashTreeNode<INT16> {

	public FlashINT16Node(final String name, final INT16 userObject) {
		super(name, userObject);
	}

	@Override
	public String toString() {
		return String.format("%s : INT16 (%d)", getName(), getUserObject().value());
	}
}
