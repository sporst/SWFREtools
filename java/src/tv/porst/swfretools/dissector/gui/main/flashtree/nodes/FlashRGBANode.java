package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.RGBA;

/**
 * Node that represents a RGBA object in the Flash tree.
 */
public final class FlashRGBANode extends FlashTreeNode<RGBA> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashRGBANode(final String name, final RGBA value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("Red", getUserObject().getRed());
		addNode("Green", getUserObject().getGreen());
		addNode("Blue", getUserObject().getBlue());
		addNode("Alpha", getUserObject().getAlpha());
	}

	@Override
	public String toString() {
		final RGBA rgb = getUserObject();

		return String.format("%s: RGB (#%02X%02X%02X%02X)", getName(), rgb.getRed().value(), rgb.getGreen().value(), rgb.getBlue().value(), rgb.getAlpha().value());
	}
}