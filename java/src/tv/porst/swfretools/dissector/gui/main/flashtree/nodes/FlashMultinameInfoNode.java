package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.MultinameInfo;

public class FlashMultinameInfoNode extends FlashTreeNode<MultinameInfo> {

	public FlashMultinameInfoNode(final String name, final MultinameInfo multinameInfo) {
		super(name, multinameInfo);

		createChildren();
	}

	private void createChildren() {
		addNode("Kind", getUserObject().getKind());
		addNode("Data", getUserObject().getData());
	}

	@Override
	public String toString() {
		return String.format("%s : multiname_info", getName());
	}
}
