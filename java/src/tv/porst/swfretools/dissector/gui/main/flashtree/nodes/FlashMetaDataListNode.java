package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.MetaData;
import tv.porst.swfretools.parser.structures.MetaDataList;

/**
 * Node that represents a MetaDataList object in the Flash tree.
 */
public final class FlashMetaDataListNode extends FlashTreeNode<MetaDataList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashMetaDataListNode(final String name, final MetaDataList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final MetaData element: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), element);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : meta_data[%d]", getName(), getUserObject().size());
	}
}