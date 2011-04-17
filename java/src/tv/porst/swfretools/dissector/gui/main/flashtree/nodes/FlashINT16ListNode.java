package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.INT16;
import tv.porst.swfretools.parser.structures.INT16List;

/**
 * Node that represents an INT16List object in the Flash tree.
 */
public final class FlashINT16ListNode extends FlashTreeNode<INT16List> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashINT16ListNode(final String name, final INT16List value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final INT16 element : getUserObject()) {
			addNode(String.format("%s[%d]", getName(), counter), element);
			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : INT16[%d]", getName(), getUserObject().size());
	}
}