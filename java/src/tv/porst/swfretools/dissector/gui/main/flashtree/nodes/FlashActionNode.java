package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.actions.as2.Action;

/**
 * Node that represents an Action object in the Flash tree.
 */
public final class FlashActionNode extends FlashTreeNode<Action> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashActionNode(final String name, final Action value) {
		super(name, value);
	}

	@Override
	public String toString() {
		return String.format("%s : ACTION", getName());
	}
}