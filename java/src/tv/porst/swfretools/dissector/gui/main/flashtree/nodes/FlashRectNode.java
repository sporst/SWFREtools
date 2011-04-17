package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.Rect;

public class FlashRectNode extends FlashTreeNode<Rect> {

	public FlashRectNode(final String name, final Rect rect) {
		super(name, rect);

		createChildren();
	}

	private void createChildren() {
		addNode("NBits", getUserObject().getnBits());
		addNode("XMin", getUserObject().getxMin());
		addNode("XMax", getUserObject().getxMax());
		addNode("YMin", getUserObject().getyMin());
		addNode("YMax", getUserObject().getyMax());
	}

	@Override
	public String toString() {
		return String.format("%s : RECT", getName());
	}
}
