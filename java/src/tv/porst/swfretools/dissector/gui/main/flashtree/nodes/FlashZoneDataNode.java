package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.ZoneData;

public class FlashZoneDataNode extends FlashTreeNode<ZoneData> {

	public FlashZoneDataNode(final String name, final ZoneData zoneData) {
		super(name, zoneData);

		createChildren();
	}

	private void createChildren() {
		addNode("AlignmentCoordinate", getUserObject().getAlignmentCoordinate());
		addNode("Range", getUserObject().getRange());
	}

	@Override
	public String toString() {
		return String.format("%s : ZONEDATA", getName());
	}
}
