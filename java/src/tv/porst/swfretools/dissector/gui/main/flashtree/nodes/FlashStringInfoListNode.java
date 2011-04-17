package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.StringInfo;
import tv.porst.swfretools.parser.structures.StringInfoList;

/**
 * Node that represents a StringInfoList object in the Flash tree.
 */
public final class FlashStringInfoListNode extends FlashTreeNode<StringInfoList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashStringInfoListNode(final String name, final StringInfoList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final StringInfo element: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), element);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : string_info[%d]", getName(), getUserObject().size());
	}
}