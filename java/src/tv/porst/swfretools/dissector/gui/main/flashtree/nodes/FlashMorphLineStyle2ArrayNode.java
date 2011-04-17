package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.MorphLineStyleArray2;

/**
 * Node that represents a MorphLineStyle2Array object in the Flash tree.
 */
public final class FlashMorphLineStyle2ArrayNode extends FlashTreeNode<MorphLineStyleArray2> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashMorphLineStyle2ArrayNode(final String name, final MorphLineStyleArray2 value) {
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
		return String.format("%s : MORPHLINESTYLEARRAY", getName());
	}
}