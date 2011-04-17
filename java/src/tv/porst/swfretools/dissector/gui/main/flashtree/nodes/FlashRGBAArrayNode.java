package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.RGBA;
import tv.porst.swfretools.parser.structures.RGBAList;

/**
 * Node that represents a RGBAArray object in the Flash tree.
 */
public final class FlashRGBAArrayNode extends FlashTreeNode<RGBAList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashRGBAArrayNode(final String name, final RGBAList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
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