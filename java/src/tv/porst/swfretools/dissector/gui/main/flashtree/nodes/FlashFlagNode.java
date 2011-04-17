package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.Flag;

public class FlashFlagNode extends FlashTreeNode<Flag> {

	public FlashFlagNode(final String name, final Flag flag) {
		super(name, flag);
	}

	@Override
	public String toString() {
		return String.format("%s : %s", getName(), getUserObject().value() ? "true" : "false");
	}

}
