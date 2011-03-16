package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.MorphGradientRecord;
import tv.porst.swfretools.parser.structures.MorphGradientRecordList;

public class FlashMorphGradientRecordListNode extends FlashTreeNode<MorphGradientRecordList> {

	public FlashMorphGradientRecordListNode(final String name, final MorphGradientRecordList fillStyleList) {
		super(name, fillStyleList);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final MorphGradientRecord gradient: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), gradient);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : MORPHGRADIENTRECORDLIST", getName());
	}
}
