package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.RGBA;

public class FlashRGBANode extends FlashTreeNode<RGBA> {

	public FlashRGBANode(final String name, final RGBA rgb) {
		super(name, rgb);

		createChildren();
	}

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
