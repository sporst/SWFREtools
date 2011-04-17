package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.TextRecord;
import tv.porst.swfretools.parser.structures.TextRecordList;

/**
 * Node that represents a TextRecordList object in the Flash tree.
 */
public final class FlashTextRecordListNode extends FlashTreeNode<TextRecordList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashTextRecordListNode(final String name, final TextRecordList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final TextRecord textRecord : getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), textRecord);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : TEXTRECORDLIST", getName());
	}
}