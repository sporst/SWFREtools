package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.Symbol;

public class FlashSymbolNode extends FlashTreeNode<Symbol> {

	public FlashSymbolNode(final String name, final Symbol symbol) {
		super(name, symbol);

		createChildren();
	}

	private void createChildren() {
		addNode("Tag", getUserObject().getTag());
		addNode("Name", getUserObject().getName());
	}

	@Override
	public String toString() {
		return String.format("%s : SYMBOL", getName());
	}
}
