package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.FillStyle3Array;

/**
 * Node that represents a FillStyle3Array object in the Flash tree.
 */
public final class FlashFillStyle3ArrayNode extends FlashTreeNode<FillStyle3Array> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashFillStyle3ArrayNode(final String name, final FillStyle3Array value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
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