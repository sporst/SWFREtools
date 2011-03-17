package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.FrameLabel;
import tv.porst.swfretools.parser.structures.FrameLabelList;

public class FlashFrameLabelListNode extends FlashTreeNode<FrameLabelList> {

	public FlashFrameLabelListNode(final String name, final FrameLabelList list) {
		super(name, list);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final FrameLabel frameLabel : getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), frameLabel);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : FRAMELABELLIST", getName());
	}
}
