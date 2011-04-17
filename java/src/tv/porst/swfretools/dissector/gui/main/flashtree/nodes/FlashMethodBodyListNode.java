package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.MethodBody;
import tv.porst.swfretools.parser.structures.MethodBodyList;

public class FlashMethodBodyListNode extends FlashTreeNode<MethodBodyList> {

	public FlashMethodBodyListNode(final String name, final MethodBodyList encodedList) {
		super(name, encodedList);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final MethodBody element: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), element);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : method_body[%d]", getName(), getUserObject().size());
	}
}
