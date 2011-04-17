package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.FillStyleArray;

public class FlashFillStyleArrayNode extends FlashTreeNode<FillStyleArray> {

	public FlashFillStyleArrayNode(final String name, final FillStyleArray fillStyleArray) {
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
		return String.format("%s : FILLSTYLEARRAY", getName());
	}
}
