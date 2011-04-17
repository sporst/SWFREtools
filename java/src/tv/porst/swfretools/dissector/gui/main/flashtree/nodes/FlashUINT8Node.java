package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.UINT8;

/**
 * Node that represents a UINT8 object in the Flash tree.
 */
public final class FlashUINT8Node extends FlashTreeNode<UINT8> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashUINT8Node(final String name, final UINT8 value) {
		super(name, value);
	}

	@Override
	public String toString() {
		return String.format("%s : UINT8 (%d)", getName(), getUserObject().value());
	}
}
