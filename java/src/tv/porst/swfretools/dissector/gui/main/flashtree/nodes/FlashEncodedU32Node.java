package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.EncodedU32;

/**
 * Node that represents a u32 object in the Flash tree.
 */
public final class FlashEncodedU32Node extends FlashTreeNode<EncodedU32> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashEncodedU32Node(final String name, final EncodedU32 value) {
		super(name, value);
	}

	@Override
	public String toString() {
		return String.format("%s : u32 (%d)", getName(), getUserObject().value());
	}
}