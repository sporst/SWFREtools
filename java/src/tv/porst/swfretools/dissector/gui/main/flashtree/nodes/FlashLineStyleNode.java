package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.LineStyle;

public class FlashLineStyleNode extends FlashTreeNode<LineStyle> {

	public FlashLineStyleNode(final String name, final LineStyle lineStyle) {
		super(name, lineStyle);

		createChildren();
	}

	private void createChildren() {
		addNode("Width", getUserObject().getWidth());
		addNode("Color", getUserObject().getColor());
	}

	@Override
	public String toString() {
		return String.format("%s : LINESTYLE", getName());
	}
}
