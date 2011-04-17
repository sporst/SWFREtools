package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.GlyphEntry;

/**
 * Node that represents a GlyphEntry object in the Flash tree.
 */
public final class FlashGlyphEntryNode extends FlashTreeNode<GlyphEntry> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashGlyphEntryNode(final String name, final GlyphEntry value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("GlyphIndex", getUserObject().getGlyphIndex());
		addNode("AdvanceIndex", getUserObject().getAdvanceIndex());
	}

	@Override
	public String toString() {
		return String.format("%s : GLYPHENTRY", getName());
	}
}