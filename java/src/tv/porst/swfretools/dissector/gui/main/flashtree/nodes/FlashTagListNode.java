package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.TagList;
import tv.porst.swfretools.parser.tags.Tag;

public class FlashTagListNode extends FlashTreeNode<TagList> {

	public FlashTagListNode(final String name, final TagList tagList) {
		super(name, tagList);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final Tag tag: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), tag);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : TAGLIST", getName());
	}
}
