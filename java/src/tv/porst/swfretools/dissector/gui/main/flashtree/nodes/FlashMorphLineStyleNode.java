package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.MorphLineStyle;

/**
 * Node that represents a MorphLineStyle object in the Flash tree.
 */
public final class FlashMorphLineStyleNode extends FlashTreeNode<MorphLineStyle> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashMorphLineStyleNode(final String name, final MorphLineStyle value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("StartWidth", getUserObject().getStartWidth());
		addNode("EndWidth", getUserObject().getEndWidth());
		addNode("StartColor", getUserObject().getStartColor());
		addNode("EndColor", getUserObject().getEndColor());
	}

	@Override
	public String toString() {
		return String.format("%s : MORPHLINESTYLE", getName());
	}
}