package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.OptionInfo;

/**
 * Node that represents a OptionInfo object in the Flash tree.
 */
public final class FlashOptionInfoNode extends FlashTreeNode<OptionInfo> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashOptionInfoNode(final String name, final OptionInfo value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("OptionCount", getUserObject().getOptionCount());
		addNode("Options", getUserObject().getOptions());
	}

	@Override
	public String toString() {
		return String.format("%s : option_info", getName());
	}
}