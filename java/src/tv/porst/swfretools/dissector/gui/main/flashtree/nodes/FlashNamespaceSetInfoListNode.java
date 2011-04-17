package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.NamespaceSetInfo;
import tv.porst.swfretools.parser.structures.NamespaceSetInfoList;

/**
 * Node that represents a NamespaceSetInfoList object in the Flash tree.
 */
public final class FlashNamespaceSetInfoListNode extends FlashTreeNode<NamespaceSetInfoList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashNamespaceSetInfoListNode(final String name, final NamespaceSetInfoList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final NamespaceSetInfo namespaceSetInfo: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), namespaceSetInfo);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : ns_set_info[%d]", getName(), getUserObject().size());
	}
}