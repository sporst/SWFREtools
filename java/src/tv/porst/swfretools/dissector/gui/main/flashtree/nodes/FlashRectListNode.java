package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.RectList;

/**
 * Node that represents a RectList object in the Flash tree.
 */
public final class FlashRectListNode extends FlashTreeNode<RectList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashRectListNode(final String name, final RectList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final Rect element : getUserObject()) {
			addNode(String.format("%s[%d]", getName(), counter), element);
			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : RECT[%d]", getName(), getUserObject().size());
	}
}