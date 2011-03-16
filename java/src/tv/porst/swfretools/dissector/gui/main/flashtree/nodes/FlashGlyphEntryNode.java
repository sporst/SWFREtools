package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.GlyphEntry;

public class FlashGlyphEntryNode extends FlashTreeNode<GlyphEntry> {

	public FlashGlyphEntryNode(final String name, final GlyphEntry glyphEntry) {
		super(name, glyphEntry);

		createChildren();
	}

	private void createChildren() {
		addNode("GlyphIndex", getUserObject().getGlyphIndex());
		addNode("AdvanceIndex", getUserObject().getAdvanceIndex());
	}

	@Override
	public String toString() {
		return String.format("%s : GLYPHENTRY", getName());
	}
}
