package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.MorphGradientRecord;

public class FlashMorphGradientRecordNode extends FlashTreeNode<MorphGradientRecord> {

	public FlashMorphGradientRecordNode(final String name, final MorphGradientRecord morphGradient) {
		super(name, morphGradient);

		createChildren();
	}

	private void createChildren() {
		addNode("StartRatio", getUserObject().getStartRatio());
		addNode("StartColor", getUserObject().getStartColor());
		addNode("EndRatio", getUserObject().getEndRatio());
		addNode("EndColor", getUserObject().getEndColor());
	}

	@Override
	public String toString() {
		return String.format("%s : MORPHGRADIENTRECORD", getName());
	}
}
