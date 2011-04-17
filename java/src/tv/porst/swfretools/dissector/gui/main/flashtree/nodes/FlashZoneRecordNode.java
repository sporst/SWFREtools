package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ZoneRecord;

/**
 * Node that represents a ZoneRecord object in the Flash tree.
 */
public final class FlashZoneRecordNode extends FlashTreeNode<ZoneRecord> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashZoneRecordNode(final String name, final ZoneRecord value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("NumZoneData", getUserObject().getNumZoneData());
		addNode("ZoneData", getUserObject().getZoneData());
		addNode("Reserved", getUserObject().getReserved());
		addNode("ZoneMaskX", getUserObject().getZoneMaskX());
		addNode("ZoneMaskY", getUserObject().getZoneMaskY());
	}

	@Override
	public String toString() {
		return String.format("%s : ZONERECORD", getName());
	}
}