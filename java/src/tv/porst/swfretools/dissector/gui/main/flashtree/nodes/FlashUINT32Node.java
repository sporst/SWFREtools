package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.UINT32;

/**
 * Node that represents a UINT32 object in the Flash tree.
 */
public final class FlashUINT32Node extends FlashTreeNode<UINT32> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashUINT32Node(final String name, final UINT32 value) {
		super(name, value);
	}

	@Override
	public String toString() {
		return String.format("%s : UINT32 (%d)", getName(), getUserObject().value());
	}
}
