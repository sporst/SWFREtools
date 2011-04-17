package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.MorphFillStyle;
import tv.porst.swfretools.parser.structures.MorphFillStyleList;

public class FlashMorphFillStyleListNode extends FlashTreeNode<MorphFillStyleList> {

	public FlashMorphFillStyleListNode(final String name, final MorphFillStyleList fillStyleList) {
		super(name, fillStyleList);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final MorphFillStyle shape: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), shape);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : MORPHFILLSTYLELIST", getName());
	}
}
