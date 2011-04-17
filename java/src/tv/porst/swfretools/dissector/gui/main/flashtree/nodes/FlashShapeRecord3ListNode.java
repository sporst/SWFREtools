package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.Shape3Record;
import tv.porst.swfretools.parser.structures.Shape3RecordList;

/**
 * Node that represents a ShapeRecord3List object in the Flash tree.
 */
public final class FlashShapeRecord3ListNode extends FlashTreeNode<Shape3RecordList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashShapeRecord3ListNode(final String name, final Shape3RecordList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final Shape3Record shape: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), shape);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : SHAPERECORDLIST", getName());
	}
}