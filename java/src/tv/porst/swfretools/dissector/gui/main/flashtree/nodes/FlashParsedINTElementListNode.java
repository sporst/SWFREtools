package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.IParsedINTElement;
import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.ParsedINTElementList;

public class FlashParsedINTElementListNode extends FlashTreeNode<ParsedINTElementList> {

	public FlashParsedINTElementListNode(final String name, final ParsedINTElementList list) {
		super(name, list);

		createChildren();
	}

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
