package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.OptionDetail;

public class FlashOptionDetailNode extends FlashTreeNode<OptionDetail> {

	public FlashOptionDetailNode(final String name, final OptionDetail optionDetail) {
		super(name, optionDetail);

		createChildren();
	}

	private void createChildren() {
		addNode("Val", getUserObject().getVal());
		addNode("Kind", getUserObject().getKind());
	}

	@Override
	public String toString() {
		return String.format("%s : option_detail", getName());
	}
}
