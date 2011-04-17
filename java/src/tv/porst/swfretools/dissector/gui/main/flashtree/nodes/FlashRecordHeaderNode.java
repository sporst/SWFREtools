package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Node that represents a RecordHeader object in the Flash tree.
 */
public final class FlashRecordHeaderNode extends FlashTreeNode<RecordHeader> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashRecordHeaderNode(final String name, final RecordHeader value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("TagAndLength", getUserObject().getTagAndLength());
		addNode("Length", getUserObject().getExtraLength());
	}

	@Override
	public String toString() {
		return String.format("%s : TAGHEADER", getName());
	}
}
