package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.GradRecord;
import tv.porst.swfretools.parser.structures.GradRecordList;

/**
 * Node that represents a GradRecordList object in the Flash tree.
 */
public final class FlashGradRecordListNode extends FlashTreeNode<GradRecordList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashGradRecordListNode(final String name, final GradRecordList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final GradRecord gradRecord: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), gradRecord);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : GRADRECORDLIST", getName());
	}
}