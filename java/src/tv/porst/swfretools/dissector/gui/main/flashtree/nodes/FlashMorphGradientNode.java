package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.MorphGradient;

/**
 * Node that represents a MorphGradientNode object in the Flash tree.
 */
public final class FlashMorphGradientNode extends FlashTreeNode<MorphGradient> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param gradient Flash structure represented by the node.
	 */
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