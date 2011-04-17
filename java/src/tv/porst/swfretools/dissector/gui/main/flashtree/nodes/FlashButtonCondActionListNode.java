package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ButtonCondAction;
import tv.porst.swfretools.parser.structures.ButtonCondActionList;

public class FlashButtonCondActionListNode extends FlashTreeNode<ButtonCondActionList> {

	public FlashButtonCondActionListNode(final String name, final ButtonCondActionList buttonCondActionList) {
		super(name, buttonCondActionList);

		createChildren();
	}

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
