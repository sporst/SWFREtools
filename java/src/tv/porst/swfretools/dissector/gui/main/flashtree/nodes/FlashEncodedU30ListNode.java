package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.EncodedU30;
import tv.porst.swfretools.parser.structures.EncodedU30List;

/**
 * Node that represents a u30List object in the Flash tree.
 */
public final class FlashEncodedU30ListNode extends FlashTreeNode<EncodedU30List> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashEncodedU30ListNode(final String name, final EncodedU30List value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final EncodedU30 element: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), element);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : u30[%d]", getName(), getUserObject().size());
	}
}