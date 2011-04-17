package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.FillStyleArray;

/**
 * Node that represents a FillStyleArray object in the Flash tree.
 */
public final class FlashFillStyleArrayNode extends FlashTreeNode<FillStyleArray> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashFillStyleArrayNode(final String name, final FillStyleArray value) {
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