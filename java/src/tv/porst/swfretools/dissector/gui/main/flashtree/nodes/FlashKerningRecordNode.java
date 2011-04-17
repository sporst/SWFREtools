package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.KerningRecord;

public class FlashKerningRecordNode extends FlashTreeNode<KerningRecord> {

	public FlashKerningRecordNode(final String name, final KerningRecord kerningRecord) {
		super(name, kerningRecord);

		createChildren();
	}

	private void createChildren() {
		addNode("FontKerningCode1", getUserObject().getFontKerningCode1());
		addNode("FontKerningCode2", getUserObject().getFontKerningCode2());
		addNode("FontKerningAdjustment", getUserObject().getFontKerningAdjustment());
	}

	@Override
	public String toString() {
		return String.format("%s : KERNINGRECORD", getName());
	}
}
