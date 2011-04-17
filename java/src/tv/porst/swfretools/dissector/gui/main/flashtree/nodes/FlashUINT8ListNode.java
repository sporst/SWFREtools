package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.structures.UINT8List;

/**
 * Node that represents a UINT8List object in the Flash tree.
 */
public final class FlashUINT8ListNode extends FlashTreeNode<UINT8List> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashUINT8ListNode(final String name, final UINT8List value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final UINT8 integer: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), integer);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : UINT8ARRAY", getName());
	}
}