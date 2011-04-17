package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.INT32;

/**
 * Node that represents an INT32 object in the Flash tree.
 */
public final class FlashINT32Node extends FlashTreeNode<INT32> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashINT32Node(final String name, final INT32 value) {
		super(name, value);
	}

	@Override
	public String toString() {
		return String.format("%s : INT32 (%d)", getName(), getUserObject().value());
	}
}
