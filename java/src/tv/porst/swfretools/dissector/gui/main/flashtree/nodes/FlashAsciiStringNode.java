package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.AsciiString;

/**
 * Node that represents an ASCII string object in the Flash tree.
 */
public final class FlashAsciiStringNode extends FlashTreeNode<AsciiString> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashAsciiStringNode(final String name, final AsciiString value) {
		super(name, value);
	}

	@Override
	public String toString() {
		return String.format("%s : STRING", getName());
	}
}
