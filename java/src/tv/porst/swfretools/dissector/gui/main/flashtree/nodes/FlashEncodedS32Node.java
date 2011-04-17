package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.EncodedS32;

/**
 * Node that represents an s32 object in the Flash tree.
 */
public final class FlashEncodedS32Node extends FlashTreeNode<EncodedS32> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashEncodedS32Node(final String name, final EncodedS32 value) {
		super(name, value);
	}

	@Override
	public String toString() {
		return String.format("%s : s32 (%d)", getName(), getUserObject().value());
	}
}
