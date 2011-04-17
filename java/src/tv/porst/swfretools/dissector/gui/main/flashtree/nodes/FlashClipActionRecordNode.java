package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ClipActionRecord;

/**
 * Node that represents a ClipActionRecord object in the Flash tree.
 */
public final class FlashClipActionRecordNode extends FlashTreeNode<ClipActionRecord> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashClipActionRecordNode(final String name, final ClipActionRecord value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("EventFlags", getUserObject().getEventFlags());
		addNode("ActionRecordSize", getUserObject().getActionRecordSize());
		addNode("KeyCode", getUserObject().getKeyCode());
		addNode("Actions", getUserObject().getActions());
	}

	@Override
	public String toString() {
		return String.format("%s : CLIPACTIONRECORD", getName());
	}
}