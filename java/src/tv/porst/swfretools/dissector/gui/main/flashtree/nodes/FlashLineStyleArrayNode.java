package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.LineStyleArray;

public class FlashLineStyleArrayNode extends FlashTreeNode<LineStyleArray> {

	public FlashLineStyleArrayNode(final String name, final LineStyleArray lineStyleArray) {
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
