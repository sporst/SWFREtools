package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ConvolutionFilter;

/**
 * Node that represents a ConvolutionFilter object in the Flash tree.
 */
public final class FlashConvolutionFilterNode extends FlashTreeNode<ConvolutionFilter> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashConvolutionFilterNode(final String name, final ConvolutionFilter value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("MatrixX", getUserObject().getMatrixX());
		addNode("MatrixY", getUserObject().getMatrixY());
		addNode("Divisor", getUserObject().getDivisor());
		addNode("Bias", getUserObject().getBias());
		addNode("Matrix", getUserObject().getMatrix());
		addNode("DefaultColor", getUserObject().getDefaultColor());
		addNode("Reserved", getUserObject().getReserved());
		addNode("Clamp", getUserObject().getClamp());
		addNode("PreserveAlpha", getUserObject().getPreserveAlpha());
	}

	@Override
	public String toString() {
		return String.format("%s : CONVOLUTIONFILTER", getName());
	}
}