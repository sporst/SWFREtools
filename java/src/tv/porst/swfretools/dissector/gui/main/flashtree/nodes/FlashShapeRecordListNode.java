package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.ShapeRecord;
import tv.porst.swfretools.parser.structures.ShapeRecordList;

public class FlashShapeRecordListNode extends FlashTreeNode<ShapeRecordList> {

	public FlashShapeRecordListNode(final String name, final ShapeRecordList shapeRecordList) {
		super(name, shapeRecordList);

		createChildren();
	}

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
