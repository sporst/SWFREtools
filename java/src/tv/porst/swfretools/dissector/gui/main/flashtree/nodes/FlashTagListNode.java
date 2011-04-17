package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.TagList;
import tv.porst.swfretools.parser.tags.Tag;

/**
 * Node that represents a TagList object in the Flash tree.
 */
public final class FlashTagListNode extends FlashTreeNode<TagList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashTagListNode(final String name, final TagList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
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