package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.FrameLabel;

public class FlashFrameLabelNode extends FlashTreeNode<FrameLabel> {

	public FlashFrameLabelNode(final String name, final FrameLabel frameLabel) {
		super(name, frameLabel);

		createChildren();
	}

	private void createChildren() {
		addNode("Offset", getUserObject().getOffset());
		addNode("Name", getUserObject().getName());
	}

	@Override
	public String toString() {
		return String.format("%s : FRAMELABEL", getName());
	}
}
