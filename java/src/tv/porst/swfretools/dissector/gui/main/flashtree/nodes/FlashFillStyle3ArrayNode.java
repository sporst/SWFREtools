package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.FillStyle3Array;

public class FlashFillStyle3ArrayNode extends FlashTreeNode<FillStyle3Array> {

	public FlashFillStyle3ArrayNode(final String name, final FillStyle3Array fillStyleArray) {
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
