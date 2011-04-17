package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.MorphLineStyle;
import tv.porst.swfretools.parser.structures.MorphLineStyleList;

public class FlashMorphLineStyleListNode extends FlashTreeNode<MorphLineStyleList> {

	public FlashMorphLineStyleListNode(final String name, final MorphLineStyleList lineStyleList) {
		super(name, lineStyleList);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final MorphLineStyle shape: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), shape);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : MORPHLINESTYLELIST", getName());
	}
}
