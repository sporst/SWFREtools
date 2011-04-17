package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.actions.as2.Action;
import tv.porst.swfretools.parser.structures.ActionList;

/**
 * Node that represents an ActionList object in the Flash tree.
 */
public final class FlashActionListNode extends FlashTreeNode<ActionList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashActionListNode(final String name, final ActionList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final Action action: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), action);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : ACTIONLIST", getName());
	}
}