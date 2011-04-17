package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.Float32;

public class FlashFloat32Node extends FlashTreeNode<Float32> {

	public FlashFloat32Node(final String name, final Float32 userObject) {
		super(name, userObject);
	}

	@Override
	public String toString() {
		return String.format("%s : FLOAT32 (%d)", getName(), getUserObject().value());
	}
}
