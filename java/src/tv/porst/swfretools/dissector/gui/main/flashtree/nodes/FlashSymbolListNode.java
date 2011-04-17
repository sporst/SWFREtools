package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.Symbol;
import tv.porst.swfretools.parser.structures.SymbolList;

/**
 * Node that represents a SymbolList object in the Flash tree.
 */
public final class FlashSymbolListNode extends FlashTreeNode<SymbolList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashSymbolListNode(final String name, final SymbolList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final Symbol symbol: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), symbol);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : SymbolList", getName());
	}
}