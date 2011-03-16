package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.CxFormWithAlpha;

public class FlashCxFormWithAlphaNode extends FlashTreeNode<CxFormWithAlpha> {

	public FlashCxFormWithAlphaNode(final String name, final CxFormWithAlpha cxForm) {
		super(name, cxForm);

		createChildren();
	}

	private void createChildren() {
		addNode("HasAddTerms", getUserObject().getHasAddTerms());
		addNode("HasMultTerms", getUserObject().getHasMultTerms());
		addNode("NBits", getUserObject().getnBits());
		addNode("RedMultTerm", getUserObject().getRedMultTerm());
		addNode("GreenMultTerm", getUserObject().getGreenMultTerm());
		addNode("BlueMultTerm", getUserObject().getBlueMultTerm());
		addNode("AlphaMultTerm", getUserObject().getAlphaMultTerm());
		addNode("RedAddTerm", getUserObject().getRedAddTerm());
		addNode("GreenAddTerm", getUserObject().getGreenAddTerm());
		addNode("BlueAddTerm", getUserObject().getBlueAddTerm());
		addNode("AlphaAddTerm", getUserObject().getAlphaAddTerm());
	}

	@Override
	public String toString() {
		return String.format("%s : CXFORMWITHALPHA", getName());
	}
}
