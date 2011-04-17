package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.MorphGradient;

public class FlashMorphGradientNode extends FlashTreeNode<MorphGradient> {

	public FlashMorphGradientNode(final String name, final MorphGradient gradient) {
		super(name, gradient);

		addNode("NumGradients", gradient.getNumGradients());
		addNode("GradientRecords", gradient.getGradientRecords());
	}

	@Override
	public String toString() {
		return String.format("%s : MORPHGRADIENT", getName());
	}
}
