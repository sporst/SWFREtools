package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ButtonCondAction;
import tv.porst.swfretools.parser.structures.ButtonCondActionList;

/**
 * Node that represents a ButtonCondActionList object in the Flash tree.
 */
public final class FlashButtonCondActionListNode extends FlashTreeNode<ButtonCondActionList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashButtonCondActionListNode(final String name, final ButtonCondActionList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final ButtonCondAction action: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), action);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : BUTTONCONDACTIONLIST", getName());
	}
}