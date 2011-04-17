package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.Float64;

/**
 * Node that represents a Float64 object in the Flash tree.
 */
public final class FlashFloat64Node extends FlashTreeNode<Float64> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashFloat64Node(final String name, final Float64 value) {
		super(name, value);
	}

	@Override
	public String toString() {
		return String.format("%s : FLOAT64 (%f)", getName(), getUserObject().value());
	}
}