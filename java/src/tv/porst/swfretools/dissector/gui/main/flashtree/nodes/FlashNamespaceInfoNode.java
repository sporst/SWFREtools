package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.NamespaceInfo;

/**
 * Node that represents a NamespaceInfo object in the Flash tree.
 */
public final class FlashNamespaceInfoNode extends FlashTreeNode<NamespaceInfo> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashNamespaceInfoNode(final String name, final NamespaceInfo value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("Kind", getUserObject().getKind());
		addNode("Name", getUserObject().getName());
	}

	@Override
	public String toString() {
		return String.format("%s : namespace_info", getName());
	}
}