package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.CxForm;

public class FlashCxFormNode extends FlashTreeNode<CxForm> {

	public FlashCxFormNode(final String name, final CxForm cxForm) {
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
		addNode("RedAddTerm", getUserObject().getRedAddTerm());
		addNode("GreenAddTerm", getUserObject().getGreenAddTerm());
		addNode("BlueAddTerm", getUserObject().getBlueAddTerm());
	}

	@Override
	public String toString() {
		return String.format("%s : CXFORM", getName());
	}
}
