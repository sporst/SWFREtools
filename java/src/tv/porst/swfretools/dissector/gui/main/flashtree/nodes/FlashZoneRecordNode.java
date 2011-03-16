package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.ZoneRecord;

public class FlashZoneRecordNode extends FlashTreeNode<ZoneRecord> {

	public FlashZoneRecordNode(final String name, final ZoneRecord zoneRecord) {
		super(name, zoneRecord);

		createChildren();
	}

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
