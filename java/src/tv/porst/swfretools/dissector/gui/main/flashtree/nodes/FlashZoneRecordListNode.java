package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ZoneRecord;
import tv.porst.swfretools.parser.structures.ZoneRecordList;

public class FlashZoneRecordListNode extends FlashTreeNode<ZoneRecordList> {

	public FlashZoneRecordListNode(final String name, final ZoneRecordList zoneRecordList) {
		super(name, zoneRecordList);

		createChildren();
	}

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