package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.RGB;

public class FlashRGBNode extends FlashTreeNode<RGB> {

	public FlashRGBNode(final String name, final RGB rgb) {
		super(name, rgb);

		createChildren();
	}

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
