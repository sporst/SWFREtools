package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.INT32;
import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;

public class FlashINT32Node extends FlashTreeNode<INT32> {

	public FlashINT32Node(final String name, final INT32 userObject) {
		super(name, userObject);
	}

	@Override
	public String toString() {
		return String.format("%s : INT32 (%d)", getName(), getUserObject().value());
	}
}
