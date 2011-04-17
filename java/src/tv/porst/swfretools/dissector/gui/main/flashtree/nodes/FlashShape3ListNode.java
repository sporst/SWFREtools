package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.Shape3;
import tv.porst.swfretools.parser.structures.Shape3List;

/**
 * Node that represents a Shape3List object in the Flash tree.
 */
public final class FlashShape3ListNode extends FlashTreeNode<Shape3List> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashShape3ListNode(final String name, final Shape3List value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final Shape3 shape: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), shape);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : ShapeList", getName());
	}
}