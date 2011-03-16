package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.LineStyle3;
import tv.porst.swfretools.parser.structures.LineStyle3List;

public class FlashLineStyle3ListNode extends FlashTreeNode<LineStyle3List> {

	public FlashLineStyle3ListNode(final String name, final LineStyle3List lineStyleList) {
		super(name, lineStyleList);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final LineStyle3 lineStyle: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), lineStyle);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : LINESTYLELIST", getName());
	}
}
