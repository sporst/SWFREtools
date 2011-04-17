package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.Flag;

/**
 * Node that represents a Flag object in the Flash tree.
 */
public final class FlashFlagNode extends FlashTreeNode<Flag> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashFlagNode(final String name, final Flag value) {
		super(name, value);
	}

	@Override
	public String toString() {
		return String.format("%s : %s", getName(), getUserObject().value() ? "true" : "false");
	}
}