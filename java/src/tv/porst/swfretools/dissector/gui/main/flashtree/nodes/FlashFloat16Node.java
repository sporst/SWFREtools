package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.Float16;
import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;

public class FlashFloat16Node extends FlashTreeNode<Float16> {

	public FlashFloat16Node(final String name, final Float16 userObject) {
		super(name, userObject);
	}

	@Override
	public String toString() {
		return String.format("%s : FLOAT16 (%d)", getName(), getUserObject().value());
	}
}
