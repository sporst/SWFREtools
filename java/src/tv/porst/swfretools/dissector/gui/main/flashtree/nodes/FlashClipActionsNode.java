package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ClipActions;

public class FlashClipActionsNode extends FlashTreeNode<ClipActions> {

	public FlashClipActionsNode(final String name, final ClipActions clipActions) {
		super(name, clipActions);

		createChildren();
	}

	private void createChildren() {
		addNode("Ratio", getUserObject().getReserved());
		addNode("AllEventFlags", getUserObject().getAllEventFlags());
		addNode("ClipActionRecords", getUserObject().getClipActionRecords());
		addNode("ClipActionEndFlag", getUserObject().getClipActionEndFlag());
	}

	@Override
	public String toString() {
		return String.format("%s : GRADRECORD", getName());
	}
}
