package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.LineStyle4Array;

/**
 * Node that represents a LineStyle4Array object in the Flash tree.
 */
public final class FlashLineStyle4ArrayNode extends FlashTreeNode<LineStyle4Array> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashLineStyle4ArrayNode(final String name, final LineStyle4Array value) {
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