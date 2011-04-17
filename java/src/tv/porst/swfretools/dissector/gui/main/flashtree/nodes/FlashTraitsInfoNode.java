package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.TraitsInfo;

/**
 * Node that represents a TraitsInfo object in the Flash tree.
 */
public final class FlashTraitsInfoNode extends FlashTreeNode<TraitsInfo> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashTraitsInfoNode(final String name, final TraitsInfo value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
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