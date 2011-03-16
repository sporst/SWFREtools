package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.RGBA;

public class FlashRGBAArrayNode extends FlashTreeNode<RGBA[]> {

	public FlashRGBAArrayNode(final String name, final RGBA[] colors) {
		super(name, colors);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final RGBA color: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), color);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : RGBAARRAY", getName());
	}
}
