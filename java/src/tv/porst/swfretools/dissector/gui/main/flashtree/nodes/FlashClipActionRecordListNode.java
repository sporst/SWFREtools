package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ClipActionRecord;
import tv.porst.swfretools.parser.structures.ClipActionRecordList;

/**
 * Node that represents a MultinameInfo object in the Flash tree.
 */
public final class FlashClipActionRecordListNode extends FlashTreeNode<ClipActionRecordList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashClipActionRecordListNode(final String name, final ClipActionRecordList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final ClipActionRecord clipActionRecord: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), clipActionRecord);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : CLIPACTIONRECORDLIST", getName());
	}
}