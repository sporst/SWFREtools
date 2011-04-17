package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.LineStyle;
import tv.porst.swfretools.parser.structures.LineStyleList;

/**
 * Node that represents a LineStyleList object in the Flash tree.
 */
public final class FlashLineStyleListNode extends FlashTreeNode<LineStyleList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashLineStyleListNode(final String name, final LineStyleList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final LineStyle shape: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), shape);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : LINESTYLELIST", getName());
	}
}