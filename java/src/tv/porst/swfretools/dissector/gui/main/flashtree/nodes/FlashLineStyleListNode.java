package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.LineStyle;
import tv.porst.swfretools.parser.structures.LineStyleList;

public class FlashLineStyleListNode extends FlashTreeNode<LineStyleList> {

	public FlashLineStyleListNode(final String name, final LineStyleList lineStyleList) {
		super(name, lineStyleList);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final LineStyle shape: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), shape);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : LINESTYLELIST", getName());
	}
}
