package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.Fixed;

public class FlashFixedNode extends FlashTreeNode<Fixed> {

	public FlashFixedNode(final String name, final Fixed userObject) {
		super(name, userObject);
	}

	@Override
	public String toString() {
		return String.format("%s : FIXED (%d)", getName(), getUserObject().value());
	}
}
