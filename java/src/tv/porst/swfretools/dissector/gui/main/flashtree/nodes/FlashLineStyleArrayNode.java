package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.LineStyleArray;

/**
 * Node that represents a LineStyleArray object in the Flash tree.
 */
public final class FlashLineStyleArrayNode extends FlashTreeNode<LineStyleArray> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashLineStyleArrayNode(final String name, final LineStyleArray value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("LineStyleCount", getUserObject().getLineStyleCount());
		addNode("LineStyleCountExtended", getUserObject().getLineStyleCountExtended());
		addNode("LineStyles", getUserObject().getLineStyles());
	}

	@Override
	public String toString() {
		return String.format("%s : LINESTYLEARRAY", getName());
	}
}