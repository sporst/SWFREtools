package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.RectList;

public class FlashRectListNode extends FlashTreeNode<RectList> {

	public FlashRectListNode(final String name, final RectList userObject) {
		super(name, userObject);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final Rect element : getUserObject()) {
			addNode(String.format("%s[%d]", getName(), counter), element);
			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : RECT[%d]", getName(), getUserObject().size());
	}
}
