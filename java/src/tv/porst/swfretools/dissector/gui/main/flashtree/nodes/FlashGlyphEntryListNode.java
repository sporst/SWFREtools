package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.GlyphEntry;
import tv.porst.swfretools.parser.structures.GlyphEntryList;

/**
 * Node that represents a GlyphEntryList object in the Flash tree.
 */
public final class FlashGlyphEntryListNode extends FlashTreeNode<GlyphEntryList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashGlyphEntryListNode(final String name, final GlyphEntryList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final GlyphEntry glyphEntry: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), glyphEntry);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : GlyphEntryList", getName());
	}
}