package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.UBits;

/**
 * Node that represents a UBits object in the Flash tree.
 */
public final class FlashUBitsNode extends FlashTreeNode<UBits> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashUBitsNode(final String name, final UBits value) {
		super(name, value);
	}

	@Override
	public String toString() {
		return String.format("%s : UBITS (%d)", getName(), getUserObject().value());
	}
}