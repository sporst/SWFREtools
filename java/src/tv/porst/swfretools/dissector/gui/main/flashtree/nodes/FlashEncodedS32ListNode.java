package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.EncodedS32;
import tv.porst.swfretools.parser.structures.EncodedS32List;

/**
 * Node that represents an s32List object in the Flash tree.
 */
public final class FlashEncodedS32ListNode extends FlashTreeNode<EncodedS32List> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashEncodedS32ListNode(final String name, final EncodedS32List value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final EncodedS32 shape: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), shape);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : s32[%d]", getName(), getUserObject().size());
	}
}