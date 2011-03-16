package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.ZoneData;
import tv.porst.swfretools.parser.structures.ZoneDataList;

public class FlashZoneDataListNode extends FlashTreeNode<ZoneDataList> {

	public FlashZoneDataListNode(final String name, final ZoneDataList zoneDataList) {
		super(name, zoneDataList);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final ZoneData zoneData: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), zoneData);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : ZONEDATALIST", getName());
	}
}