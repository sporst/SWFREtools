package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.FocalGradient;
import tv.porst.swfretools.parser.structures.Gradient;
import tv.porst.swfretools.parser.structures.Gradient3;
import tv.porst.swfretools.parser.structures.IGradient;

/**
 * Node that represents a Gradient object in the Flash tree.
 */
public class FlashGradientNode extends FlashTreeNode<IGradient> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashGradientNode(final String name, final IGradient value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		if (getUserObject() instanceof Gradient) {
			final Gradient cgradient = (Gradient) getUserObject();
			addNode("SpreadMode", cgradient.getSpreadMode());
			addNode("InterpolationMode", cgradient.getInterpolationMode());
			addNode("NumGradients", cgradient.getNumGradients());
			addNode("GradientRecords", cgradient.getGradientRecords());
		}
		else if (getUserObject() instanceof Gradient3) {
			final Gradient3 cgradient = (Gradient3) getUserObject();
			addNode("SpreadMode", cgradient.getSpreadMode());
			addNode("InterpolationMode", cgradient.getInterpolationMode());
			addNode("NumGradients", cgradient.getNumGradients());
			addNode("GradientRecords", cgradient.getGradientRecords());
		}
		else if (getUserObject() instanceof FocalGradient) {
			final FocalGradient cgradient = (FocalGradient) getUserObject();
			addNode("SpreadMode", cgradient.getSpreadMode());
			addNode("InterpolationMode", cgradient.getInterpolationMode());
			addNode("NumGradients", cgradient.getNumGradients());
			addNode("GradientRecords", cgradient.getGradientRecords());
			addNode("FocalPoint", cgradient.getFocalPoint());
		}
		else {
			throw new IllegalStateException("Error: Unknown gradient type");
		}
	}

	/**
	 * Returns the gradient name for each specific gradient type.
	 * 
	 * @return The gradient name.
	 */
	private String getGradientName() {

		if (getUserObject() instanceof Gradient) {
			return "Gradient";
		}
		else if (getUserObject() instanceof Gradient3) {
			return "Gradient3";
		}
		else if (getUserObject() instanceof FocalGradient) {
			return "FocaleGradient";
		}
		else {
			throw new IllegalStateException("Error: Unknown gradient type");
		}
	}

	@Override
	public String toString() {
		return String.format("%s : %s", getName(), getGradientName());
	}
}