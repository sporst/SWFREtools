package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ButtonRecord2;
import tv.porst.swfretools.parser.structures.ButtonRecord2List;

/**
 * Node that represents a ButtonRecord2List object in the Flash tree.
 */
public final class FlashButtonRecord2ListNode extends FlashTreeNode<ButtonRecord2List> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashButtonRecord2ListNode(final String name, final ButtonRecord2List value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final ButtonRecord2 buttonRecord: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), buttonRecord);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : BUTTONRECORDLIST", getName());
	}
}