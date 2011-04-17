package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.Shape3Record;
import tv.porst.swfretools.parser.structures.Shape3RecordList;

public class FlashShapeRecord3ListNode extends FlashTreeNode<Shape3RecordList> {

	public FlashShapeRecord3ListNode(final String name, final Shape3RecordList shapeRecordList) {
		super(name, shapeRecordList);

		createChildren();
	}

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
