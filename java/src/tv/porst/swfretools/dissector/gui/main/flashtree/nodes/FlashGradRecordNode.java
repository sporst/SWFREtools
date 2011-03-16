package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.GradRecord;

public class FlashGradRecordNode extends FlashTreeNode<GradRecord> {

	public FlashGradRecordNode(final String name, final GradRecord gradRecord) {
		super(name, gradRecord);

		createChildren();
	}

	private void createChildren() {
		addNode("Ratio", getUserObject().getRatio());
		addNode("Color", getUserObject().getColor());
	}

	@Override
	public String toString() {
		return String.format("%s : GRADRECORD", getName());
	}
}
