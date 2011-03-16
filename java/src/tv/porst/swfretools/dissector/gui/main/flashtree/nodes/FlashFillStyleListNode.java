package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.FillStyle;
import tv.porst.swfretools.parser.structures.FillStyleList;

public class FlashFillStyleListNode extends FlashTreeNode<FillStyleList> {

	public FlashFillStyleListNode(final String name, final FillStyleList fillStyleList) {
		super(name, fillStyleList);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final FillStyle shape: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), shape);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : FILLSTYLELIST", getName());
	}
}
