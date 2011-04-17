package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.LineStyle4;
import tv.porst.swfretools.parser.structures.LineStyle4List;

/**
 * Node that represents a LineStyle4List object in the Flash tree.
 */
public final class FlashLineStyle4ListNode extends FlashTreeNode<LineStyle4List> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashLineStyle4ListNode(final String name, final LineStyle4List value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final LineStyle4 lineStyle: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), lineStyle);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : LINESTYLELIST", getName());
	}
}