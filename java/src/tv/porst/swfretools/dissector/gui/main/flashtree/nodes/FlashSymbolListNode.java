package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.Symbol;
import tv.porst.swfretools.parser.structures.SymbolList;

public class FlashSymbolListNode extends FlashTreeNode<SymbolList> {

	public FlashSymbolListNode(final String name, final SymbolList symbolList) {
		super(name, symbolList);

		createChildren();
	}

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
