package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ByteArray;

/**
 * Node that represents a ByteArray object in the Flash tree.
 */
public final class FlashByteArrayNode extends FlashTreeNode<ByteArray> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashByteArrayNode(final String name, final ByteArray value) {
		super(name, value);
	}

	@Override
	public String toString() {
		return String.format("%s : BYTEARRAY[%d]", getName(), getUserObject().getValue().length);
	}
}