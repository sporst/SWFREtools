package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.Shape;
import tv.porst.swfretools.parser.structures.ShapeList;

public class FlashShapeListNode extends FlashTreeNode<ShapeList> {

	public FlashShapeListNode(final String name, final ShapeList shapeList) {
		super(name, shapeList);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final Shape shape: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), shape);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : ShapeList", getName());
	}

}
