package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.FillStyle3;
import tv.porst.swfretools.parser.structures.FillStyle3List;

public class FlashFillStyle3ListNode extends FlashTreeNode<FillStyle3List> {

	public FlashFillStyle3ListNode(final String name, final FillStyle3List fillStyleList) {
		super(name, fillStyleList);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final FillStyle3 shape: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), shape);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : FILLSTYLELIST", getName());
	}
}
