package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.MetaData;

/**
 * Node that represents a MetaData object in the Flash tree.
 */
public final class FlashMetaDataNode extends FlashTreeNode<MetaData> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashMetaDataNode(final String name, final MetaData value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("Name", getUserObject().getName());
		addNode("ItemCount", getUserObject().getItemCount());
		addNode("Items", getUserObject().getItems());
	}

	@Override
	public String toString() {
		return String.format("%s : meta_data", getName());
	}
}