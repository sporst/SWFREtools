package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.INT16;

/**
 * Node that represents an INT16 object in the Flash tree.
 */
public class FlashINT16Node extends FlashTreeNode<INT16> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashINT16Node(final String name, final INT16 value) {
		super(name, value);
	}

	@Override
	public String toString() {
		return String.format("%s : INT16 (%d)", getName(), getUserObject().value());
	}
}