package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.Float16;

/**
 * Node that represents a Float16 object in the Flash tree.
 */
public final class FlashFloat16Node extends FlashTreeNode<Float16> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashFloat16Node(final String name, final Float16 value) {
		super(name, value);
	}

	@Override
	public String toString() {
		return String.format("%s : FLOAT16 (%d)", getName(), getUserObject().value());
	}
}
