package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.NamespaceInfo;
import tv.porst.swfretools.parser.structures.NamespaceInfoList;

/**
 * Node that represents a MultinameInfo object in the Flash tree.
 */
public final class FlashNamespaceInfoListNode extends FlashTreeNode<NamespaceInfoList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashNamespaceInfoListNode(final String name, final NamespaceInfoList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final NamespaceInfo namespaceInfo: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), namespaceInfo);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : namespace_info[%d]", getName(), getUserObject().size());
	}
}