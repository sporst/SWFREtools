package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.TraitsInfo;

public class FlashTraitsInfoNode extends FlashTreeNode<TraitsInfo> {

	public FlashTraitsInfoNode(final String name, final TraitsInfo traitsInfo) {
		super(name, traitsInfo);

		createChildren();
	}

	private void createChildren() {
		addNode("name", getUserObject().getName());
		addNode("data", getUserObject().getData());
		addNode("metadata_count", getUserObject().getMetaDataCount());
		addNode("metadata", getUserObject().getMetaData());
	}

	@Override
	public String toString() {
		return String.format("%s : traits_info", getName());
	}
}
