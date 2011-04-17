package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ZoneRecord;
import tv.porst.swfretools.parser.structures.ZoneRecordList;

/**
 * Node that represents a ZoneRecordList object in the Flash tree.
 */
public final class FlashZoneRecordListNode extends FlashTreeNode<ZoneRecordList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashZoneRecordListNode(final String name, final ZoneRecordList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final ZoneRecord zoneRecord: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), zoneRecord);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : ZONERECORDLIST", getName());
	}
}