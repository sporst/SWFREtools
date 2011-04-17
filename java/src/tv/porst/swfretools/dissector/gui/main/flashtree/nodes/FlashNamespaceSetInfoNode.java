package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.NamespaceSetInfo;

/**
 * Node that represents a NamespaceSetInfo object in the Flash tree.
 */
public final class FlashNamespaceSetInfoNode extends FlashTreeNode<NamespaceSetInfo> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashNamespaceSetInfoNode(final String name, final NamespaceSetInfo value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("Count", getUserObject().getCount());
		addNode("Namespaces", getUserObject().getNamespaces());
	}

	@Override
	public String toString() {
		return String.format("%s : ns_set_info", getName());
	}
}