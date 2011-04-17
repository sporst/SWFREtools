package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.LineStyle4;
import tv.porst.swfretools.parser.structures.LineStyle4List;

public class FlashLineStyle4ListNode extends FlashTreeNode<LineStyle4List> {

	public FlashLineStyle4ListNode(final String name, final LineStyle4List lineStyleList) {
		super(name, lineStyleList);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final LineStyle4 lineStyle: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), lineStyle);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : LINESTYLELIST", getName());
	}
}
