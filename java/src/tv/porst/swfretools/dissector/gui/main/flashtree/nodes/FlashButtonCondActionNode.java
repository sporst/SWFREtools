package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ButtonCondAction;

/**
 * Node that represents a ButtonCondAction object in the Flash tree.
 */
public final class FlashButtonCondActionNode extends FlashTreeNode<ButtonCondAction> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashButtonCondActionNode(final String name, final ButtonCondAction value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("CondActionSize", getUserObject().getCondActionSize());
		addNode("CondIdleToOverDown", getUserObject().getCondIdleToOverDown());
		addNode("CondOutDownToIdle", getUserObject().getCondOutDownToIdle());
		addNode("CondOutDownToOverDown", getUserObject().getCondOutDownToOverDown());
		addNode("CondOverDownToOutDown", getUserObject().getCondOverDownToOutDown());
		addNode("CondOverDownToOverUp", getUserObject().getCondOverDownToOverUp());
		addNode("CondOverUpToOverDown", getUserObject().getCondOverUpToOverDown());
		addNode("CondOverDownToIdle", getUserObject().getCondOverDownToIdle());
		addNode("CondIdleToOverUp", getUserObject().getCondIdleToOverUp());
		addNode("CondKeyPress", getUserObject().getCondKeyPress());
		addNode("CondOverDownToIdle", getUserObject().getCondOverDownToIdle());
		addNode("Actions", getUserObject().getActions());
		addNode("ActionEndFlag", getUserObject().getActionEndFlag());
	}

	@Override
	public String toString() {
		return String.format("%s : BUTTONCONDACTION", getName());
	}
}