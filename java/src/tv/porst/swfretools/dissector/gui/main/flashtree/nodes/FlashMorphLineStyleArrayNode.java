package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.MorphLineStyleArray;

/**
 * Node that represents a MorphLineStyleArray object in the Flash tree.
 */
public final class FlashMorphLineStyleArrayNode extends FlashTreeNode<MorphLineStyleArray> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashMorphLineStyleArrayNode(final String name, final MorphLineStyleArray value) {
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