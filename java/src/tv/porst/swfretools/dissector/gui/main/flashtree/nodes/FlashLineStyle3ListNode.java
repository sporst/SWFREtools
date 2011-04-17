package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.LineStyle3;
import tv.porst.swfretools.parser.structures.LineStyle3List;

/**
 * Node that represents a LineStyle3List object in the Flash tree.
 */
public final class FlashLineStyle3ListNode extends FlashTreeNode<LineStyle3List> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashLineStyle3ListNode(final String name, final LineStyle3List value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final LineStyle3 lineStyle: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), lineStyle);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : LINESTYLELIST", getName());
	}
}