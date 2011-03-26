package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.OptionDetail;
import tv.porst.swfretools.parser.structures.OptionDetailList;

public class FlashOptionDetailListNode extends FlashTreeNode<OptionDetailList> {

	public FlashOptionDetailListNode(final String name, final OptionDetailList encodedList) {
		super(name, encodedList);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final OptionDetail optionDetail: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), optionDetail);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : option_detail[%d]", getName(), getUserObject().size());
	}
}
