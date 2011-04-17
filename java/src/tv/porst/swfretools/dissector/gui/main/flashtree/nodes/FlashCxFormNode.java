package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.CxForm;

/**
 * Node that represents a CxForm object in the Flash tree.
 */
public final class FlashCxFormNode extends FlashTreeNode<CxForm> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashCxFormNode(final String name, final CxForm value) {
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
		addNode("RedAddTerm", getUserObject().getRedAddTerm());
		addNode("GreenAddTerm", getUserObject().getGreenAddTerm());
		addNode("BlueAddTerm", getUserObject().getBlueAddTerm());
	}

	@Override
	public String toString() {
		return String.format("%s : CXFORM", getName());
	}
}