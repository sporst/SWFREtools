package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.Fixed8;

public class FlashFixed8Node extends FlashTreeNode<Fixed8> {

	public FlashFixed8Node(final String name, final Fixed8 userObject) {
		super(name, userObject);
	}

	@Override
	public String toString() {
		return String.format("%s : FIXED8 (%d)", getName(), getUserObject().value());
	}
}
