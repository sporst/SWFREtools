package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ButtonCondAction;

public class FlashButtonCondActionNode extends FlashTreeNode<ButtonCondAction> {

	public FlashButtonCondActionNode(final String name, final ButtonCondAction filter) {
		super(name, filter);

		createChildren();
	}

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
