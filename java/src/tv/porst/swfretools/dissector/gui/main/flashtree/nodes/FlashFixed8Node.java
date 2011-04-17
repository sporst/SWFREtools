package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.Fixed8;

/**
 * Node that represents a FIXED8 object in the Flash tree.
 */
public final class FlashFixed8Node extends FlashTreeNode<Fixed8> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashFixed8Node(final String name, final Fixed8 value) {
		super(name, value);
	}

	@Override
	public String toString() {
		return String.format("%s : FIXED8 (%d)", getName(), getUserObject().value());
	}
}