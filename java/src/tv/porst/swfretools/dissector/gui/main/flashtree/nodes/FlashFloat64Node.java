package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.Float64;
import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;

public class FlashFloat64Node extends FlashTreeNode<Float64> {

	public FlashFloat64Node(final String name, final Float64 userObject) {
		super(name, userObject);
	}

	@Override
	public String toString() {
		return String.format("%s : FLOAT64 (%f)", getName(), getUserObject().value());
	}
}
