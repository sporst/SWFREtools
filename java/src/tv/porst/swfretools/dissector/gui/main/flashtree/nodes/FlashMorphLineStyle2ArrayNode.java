package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.MorphLineStyleArray2;

public class FlashMorphLineStyle2ArrayNode extends FlashTreeNode<MorphLineStyleArray2> {

	public FlashMorphLineStyle2ArrayNode(final String name, final MorphLineStyleArray2 lineStyleArray) {
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
		return String.format("%s : MORPHLINESTYLEARRAY", getName());
	}
}
