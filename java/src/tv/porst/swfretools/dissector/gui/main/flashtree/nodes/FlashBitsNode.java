package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.Bits;

/**
 * Node that represents a Bits object in the Flash tree.
 */
public final class FlashBitsNode extends FlashTreeNode<Bits> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashBitsNode(final String name, final Bits value) {
		super(name, value);
	}

	@Override
	public String toString() {
		return String.format("%s : UBITS (%d)", getName(), getUserObject().value());
	}
}