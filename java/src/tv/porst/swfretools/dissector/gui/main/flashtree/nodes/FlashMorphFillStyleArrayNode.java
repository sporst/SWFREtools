package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.MorphFillStyleArray;

public class FlashMorphFillStyleArrayNode extends FlashTreeNode<MorphFillStyleArray> {

	public FlashMorphFillStyleArrayNode(final String name, final MorphFillStyleArray fillStyleArray) {
		super(name, fillStyleArray);

		createChildren();
	}

	private void createChildren() {
		addNode("FillStyleCount", getUserObject().getFillStyleCount());
		addNode("FillStyleCountExtended", getUserObject().getFillStyleCountExtended());
		addNode("FillStyles", getUserObject().getFillStyles());
	}

	@Override
	public String toString() {
		return String.format("%s : MORPHFILLSTYLEARRAY", getName());
	}
}
