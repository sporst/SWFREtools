package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.actions.as2.Action;
import tv.porst.swfretools.parser.structures.ActionList;

public class FlashActionListNode extends FlashTreeNode<ActionList> {

	public FlashActionListNode(final String name, final ActionList actionList) {
		super(name, actionList);

		createChildren();
	}

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
