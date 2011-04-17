package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.FillStyle3;
import tv.porst.swfretools.parser.structures.FillStyle3List;

/**
 * Node that represents a FillStyle3List object in the Flash tree.
 */
public final class FlashFillStyle3ListNode extends FlashTreeNode<FillStyle3List> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashFillStyle3ListNode(final String name, final FillStyle3List value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final FillStyle3 shape: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), shape);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : FILLSTYLELIST", getName());
	}
}