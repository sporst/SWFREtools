package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.FillStyle;
import tv.porst.swfretools.parser.structures.FillStyleList;

/**
 * Node that represents a FillStyleList object in the Flash tree.
 */
public final class FlashFillStyleListNode extends FlashTreeNode<FillStyleList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashFillStyleListNode(final String name, final FillStyleList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final FillStyle shape: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), shape);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : FILLSTYLELIST", getName());
	}
}