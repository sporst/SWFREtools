package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.LineStyle4Array;

public class FlashLineStyle4ArrayNode extends FlashTreeNode<LineStyle4Array> {

	public FlashLineStyle4ArrayNode(final String name, final LineStyle4Array lineStyleArray) {
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
