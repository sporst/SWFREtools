package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.StringInfo;

/**
 * Node that represents a StringInfo object in the Flash tree.
 */
public final class FlashStringInfoNode extends FlashTreeNode<StringInfo> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashStringInfoNode(final String name, final StringInfo value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("Size", getUserObject().getSize());
		addNode("Name", getUserObject().getName());
	}

	@Override
	public String toString() {
		return String.format("%s : string_info", getName());
	}
}