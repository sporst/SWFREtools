package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.EncodedU30;

/**
 * Node that represents a u32 object in the Flash tree.
 */
public final class FlashEncodedU30Node extends FlashTreeNode<EncodedU30> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashEncodedU30Node(final String name, final EncodedU30 value) {
		super(name, value);
	}

	@Override
	public String toString() {
		return String.format("%s : u30 (%d)", getName(), getUserObject().value());
	}
}