package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.GradRecord3;

public class FlashGradRecord3Node extends FlashTreeNode<GradRecord3> {

	public FlashGradRecord3Node(final String name, final GradRecord3 gradRecord) {
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
