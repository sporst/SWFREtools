package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.CxFormWithAlpha;

/**
 * Node that represents a CxFormWithAlpha object in the Flash tree.
 */
public final class FlashCxFormWithAlphaNode extends FlashTreeNode<CxFormWithAlpha> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashCxFormWithAlphaNode(final String name, final CxFormWithAlpha value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
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