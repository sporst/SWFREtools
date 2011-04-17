package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.structures.UINT16List;

/**
 * Node that represents a UINT16List object in the Flash tree.
 */
public final class FlashUINT16ListNode extends FlashTreeNode<UINT16List> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashUINT16ListNode(final String name, final UINT16List value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final UINT16 element : getUserObject()) {
			addNode(String.format("%s[%d]", getName(), counter), element);
			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : UINT16[%d]", getName(), getUserObject().size());
	}
}