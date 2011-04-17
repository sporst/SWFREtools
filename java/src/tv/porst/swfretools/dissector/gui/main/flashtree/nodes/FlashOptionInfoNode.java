package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.OptionInfo;

public class FlashOptionInfoNode extends FlashTreeNode<OptionInfo> {

	public FlashOptionInfoNode(final String name, final OptionInfo optionInfo) {
		super(name, optionInfo);

		createChildren();
	}

	private void createChildren() {
		addNode("OptionCount", getUserObject().getOptionCount());
		addNode("Options", getUserObject().getOptions());
	}

	@Override
	public String toString() {
		return String.format("%s : option_info", getName());
	}
}
