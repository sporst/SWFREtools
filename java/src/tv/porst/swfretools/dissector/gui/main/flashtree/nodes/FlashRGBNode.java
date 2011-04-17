package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.RGB;

/**
 * Node that represents an RGB object in the Flash tree.
 */
public final class FlashRGBNode extends FlashTreeNode<RGB> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashRGBNode(final String name, final RGB value) {
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
	}

	@Override
	public String toString() {
		final RGB rgb = getUserObject();

		return String.format("%s: RGB (#%02X%02X%02X)", getName(), rgb.getRed().value(), rgb.getGreen().value(), rgb.getBlue().value());
	}
}