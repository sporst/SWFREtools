package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.MorphLineStyle2;
import tv.porst.swfretools.parser.structures.MorphLineStyle2List;

public class FlashMorphLineStyle2ListNode extends FlashTreeNode<MorphLineStyle2List> {

	public FlashMorphLineStyle2ListNode(final String name, final MorphLineStyle2List lineStyleList) {
		super(name, lineStyleList);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final MorphLineStyle2 lineStyle: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), lineStyle);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : MORPHLINESTYLELIST", getName());
	}
}
