package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ZoneData;

/**
 * Node that represents a ZoneData object in the Flash tree.
 */
public final class FlashZoneDataNode extends FlashTreeNode<ZoneData> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashZoneDataNode(final String name, final ZoneData value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("AlignmentCoordinate", getUserObject().getAlignmentCoordinate());
		addNode("Range", getUserObject().getRange());
	}

	@Override
	public String toString() {
		return String.format("%s : ZONEDATA", getName());
	}
}