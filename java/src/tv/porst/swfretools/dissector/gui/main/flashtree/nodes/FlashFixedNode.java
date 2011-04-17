package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.Fixed;

/**
 * Node that represents a FIXED object in the Flash tree.
 */
public final class FlashFixedNode extends FlashTreeNode<Fixed> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashFixedNode(final String name, final Fixed value) {
		super(name, value);
	}

	@Override
	public String toString() {
		return String.format("%s : FIXED (%d)", getName(), getUserObject().value());
	}
}