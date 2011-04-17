package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ConvolutionFilter;

public class FlashConvolutionFilterNode extends FlashTreeNode<ConvolutionFilter> {

	public FlashConvolutionFilterNode(final String name, final ConvolutionFilter filter) {
		super(name, filter);

		createChildren();
	}

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
