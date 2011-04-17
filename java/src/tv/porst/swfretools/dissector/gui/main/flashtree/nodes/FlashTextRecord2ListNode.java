package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.TextRecord2;
import tv.porst.swfretools.parser.structures.TextRecord2List;

/**
 * Node that represents a TextRecord2List object in the Flash tree.
 */
public final class FlashTextRecord2ListNode extends FlashTreeNode<TextRecord2List> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashTextRecord2ListNode(final String name, final TextRecord2List value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final TextRecord2 textRecord : getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), textRecord);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : TEXTRECORDLIST", getName());
	}
}