package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.LineStyle3;

public class FlashLineStyle3Node extends FlashTreeNode<LineStyle3> {

	public FlashLineStyle3Node(final String name, final LineStyle3 lineStyle) {
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
