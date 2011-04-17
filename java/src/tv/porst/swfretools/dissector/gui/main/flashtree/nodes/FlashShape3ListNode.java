package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.Shape3;
import tv.porst.swfretools.parser.structures.Shape3List;

public class FlashShape3ListNode extends FlashTreeNode<Shape3List> {

	public FlashShape3ListNode(final String name, final Shape3List shapeList) {
		super(name, shapeList);

		createChildren();
	}

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
