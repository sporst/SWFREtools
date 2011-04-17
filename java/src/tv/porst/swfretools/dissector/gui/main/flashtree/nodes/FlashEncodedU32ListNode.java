package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.EncodedU32;
import tv.porst.swfretools.parser.structures.EncodedU32List;

/**
 * Node that represents a u32List object in the Flash tree.
 */
public final class FlashEncodedU32ListNode extends FlashTreeNode<EncodedU32List> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashEncodedU32ListNode(final String name, final EncodedU32List value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final EncodedU32 element: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), element);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : u32[%d]", getName(), getUserObject().size());
	}
}