package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.Float64;
import tv.porst.swfretools.parser.structures.Float64List;

/**
 * Node that represents a Float64List object in the Flash tree.
 */
public final class FlashFloat64ListNode extends FlashTreeNode<Float64List> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashFloat64ListNode(final String name, final Float64List value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final Float64 element: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), element);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : double[%d]", getName(), getUserObject().size());
	}
}