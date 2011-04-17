package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ZoneData;
import tv.porst.swfretools.parser.structures.ZoneDataList;

/**
 * Node that represents a FlashZoneDataList object in the Flash tree.
 */
public final class FlashZoneDataListNode extends FlashTreeNode<ZoneDataList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashZoneDataListNode(final String name, final ZoneDataList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
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