package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.GlyphEntry;
import tv.porst.swfretools.parser.structures.GlyphEntryList;

public class FlashGlyphEntryListNode extends FlashTreeNode<GlyphEntryList> {

	public FlashGlyphEntryListNode(final String name, final GlyphEntryList glyphEntryList) {
		super(name, glyphEntryList);

		createChildren();
	}

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
