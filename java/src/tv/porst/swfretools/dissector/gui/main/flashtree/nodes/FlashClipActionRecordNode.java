package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.ClipActionRecord;

public class FlashClipActionRecordNode extends FlashTreeNode<ClipActionRecord> {

	public FlashClipActionRecordNode(final String name, final ClipActionRecord clipActionRecord) {
		super(name, clipActionRecord);

		createChildren();
	}

	private void createChildren() {
		addNode("EventFlags", getUserObject().getEventFlags());
		addNode("ActionRecordSize", getUserObject().getActionRecordSize());
		addNode("KeyCode", getUserObject().getKeyCode());
		addNode("Actions", getUserObject().getActions());
	}

	@Override
	public String toString() {
		return String.format("%s : CLIPACTIONRECORD", getName());
	}
}
