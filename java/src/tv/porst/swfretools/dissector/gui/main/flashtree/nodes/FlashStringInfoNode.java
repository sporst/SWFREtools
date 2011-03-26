package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.StringInfo;

public class FlashStringInfoNode extends FlashTreeNode<StringInfo> {

	public FlashStringInfoNode(final String name, final StringInfo stringInfo) {
		super(name, stringInfo);

		createChildren();
	}

	private void createChildren() {
		addNode("Size", getUserObject().getSize());
		addNode("Name", getUserObject().getName());
	}

	@Override
	public String toString() {
		return String.format("%s : string_info", getName());
	}
}
