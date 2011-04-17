package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.RecordHeader;

public class FlashRecordHeaderNode extends FlashTreeNode<RecordHeader> {

	public FlashRecordHeaderNode(final String name, final RecordHeader recordHeader) {
		super(name, recordHeader);

		createChildren();
	}

	private void createChildren() {
	}

	@Override
	public String toString() {
		return String.format("%s : TAGHEADER", getName());
	}
}
