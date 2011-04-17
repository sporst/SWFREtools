package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.LineStyle3Array;

public class FlashLineStyle3ArrayNode extends FlashTreeNode<LineStyle3Array> {

	public FlashLineStyle3ArrayNode(final String name, final LineStyle3Array lineStyleArray) {
		super(name, lineStyleArray);

		createChildren();
	}

	private void createChildren() {
		addNode("LineStyleCount", getUserObject().getLineStyleCount());
		addNode("LineStyleCountExtended", getUserObject().getLineStyleCountExtended());
		addNode("LineStyles", getUserObject().getLineStyles());
	}

	@Override
	public String toString() {
		return String.format("%s : LINESTYLEARRAY", getName());
	}
}
