package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.MorphFillStyle;
import tv.porst.swfretools.parser.structures.MorphFillStyleList;

/**
 * Node that represents a MorphFillStyleList object in the Flash tree.
 */
public final class FlashMorphFillStyleListNode extends FlashTreeNode<MorphFillStyleList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashMorphFillStyleListNode(final String name, final MorphFillStyleList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final MorphFillStyle shape: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), shape);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : MORPHFILLSTYLELIST", getName());
	}
}