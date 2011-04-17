package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.MorphLineStyle;
import tv.porst.swfretools.parser.structures.MorphLineStyleList;

/**
 * Node that represents a MorphLineStyleList object in the Flash tree.
 */
public final class FlashMorphLineStyleListNode extends FlashTreeNode<MorphLineStyleList> {


	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashMorphLineStyleListNode(final String name, final MorphLineStyleList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final MorphLineStyle shape: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), shape);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : MORPHLINESTYLELIST", getName());
	}
}