package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.Float32;

/**
 * Node that represents a Float32 object in the Flash tree.
 */
public final class FlashFloat32Node extends FlashTreeNode<Float32> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashFloat32Node(final String name, final Float32 value) {
		super(name, value);
	}

	@Override
	public String toString() {
		return String.format("%s : FLOAT32 (%d)", getName(), getUserObject().value());
	}
}