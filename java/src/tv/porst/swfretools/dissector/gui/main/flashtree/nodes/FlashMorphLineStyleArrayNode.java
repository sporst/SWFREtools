package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.MorphLineStyleArray;

public class FlashMorphLineStyleArrayNode extends FlashTreeNode<MorphLineStyleArray> {

	public FlashMorphLineStyleArrayNode(final String name, final MorphLineStyleArray lineStyleArray) {
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
