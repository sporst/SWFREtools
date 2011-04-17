package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.UINT16;

/**
 * Node that represents a UINT16 object in the Flash tree.
 */
public final class FlashUINT16Node extends FlashTreeNode<UINT16> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashUINT16Node(final String name, final UINT16 value) {
		super(name, value);
	}

	@Override
	public String toString() {
		return String.format("%s : UINT16 (%d)", getName(), getUserObject().value());
	}
}