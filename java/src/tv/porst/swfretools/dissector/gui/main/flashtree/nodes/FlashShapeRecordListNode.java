package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ShapeRecord;
import tv.porst.swfretools.parser.structures.ShapeRecordList;

/**
 * Node that represents a ShapeRecordList object in the Flash tree.
 */
public final class FlashShapeRecordListNode extends FlashTreeNode<ShapeRecordList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashShapeRecordListNode(final String name, final ShapeRecordList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final ShapeRecord shape: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), shape);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : SHAPERECORDLIST", getName());
	}
}