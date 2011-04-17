package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.Symbol;

/**
 * Node that represents a Symbol object in the Flash tree.
 */
public final class FlashSymbolNode extends FlashTreeNode<Symbol> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashSymbolNode(final String name, final Symbol value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("Tag", getUserObject().getTag());
		addNode("Name", getUserObject().getName());
	}

	@Override
	public String toString() {
		return String.format("%s : SYMBOL", getName());
	}
}