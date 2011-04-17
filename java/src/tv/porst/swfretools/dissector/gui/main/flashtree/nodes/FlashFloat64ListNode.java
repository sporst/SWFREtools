package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.Float64;
import tv.porst.swfretools.parser.structures.Float64List;

public class FlashFloat64ListNode extends FlashTreeNode<Float64List> {

	public FlashFloat64ListNode(final String name, final Float64List encodedList) {
		super(name, encodedList);

		createChildren();
	}

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
