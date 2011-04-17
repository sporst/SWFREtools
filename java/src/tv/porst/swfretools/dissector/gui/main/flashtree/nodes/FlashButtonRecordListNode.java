package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ButtonRecord;
import tv.porst.swfretools.parser.structures.ButtonRecordList;

/**
 * Node that represents a ButtonRecordList object in the Flash tree.
 */
public final class FlashButtonRecordListNode extends FlashTreeNode<ButtonRecordList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashButtonRecordListNode(final String name, final ButtonRecordList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final ButtonRecord buttonRecord: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), buttonRecord);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : BUTTONRECORDLIST", getName());
	}
}