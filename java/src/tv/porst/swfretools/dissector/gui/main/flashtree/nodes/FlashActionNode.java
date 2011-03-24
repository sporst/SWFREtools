package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.actions.as2.Action;

public class FlashActionNode extends FlashTreeNode<Action> {

	public FlashActionNode(final String name, final Action action) {
		super(name, action);

		createChildren();
	}

	private void createChildren() {
	}

	@Override
	public String toString() {
		return String.format("%s : ACTION", getName());
	}
}
