package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.EncodedU30;

public class FlashEncodedU30Node extends FlashTreeNode<EncodedU30> {

	public FlashEncodedU30Node(final String name, final EncodedU30 userObject) {
		super(name, userObject);
	}

	@Override
	public String toString() {
		return String.format("%s : u30 (%d)", getName(), getUserObject().value());
	}
}
