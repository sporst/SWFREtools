package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.IParsedINTElement;
import tv.porst.swfretools.parser.structures.ParsedINTElementList;

/**
 * Node that represents a INTElementList object in the Flash tree.
 */
public final class FlashParsedINTElementListNode extends FlashTreeNode<ParsedINTElementList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashParsedINTElementListNode(final String name, final ParsedINTElementList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final IParsedINTElement shape: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), shape);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : INTLIST", getName());
	}
}