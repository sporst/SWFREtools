package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.OptionDetail;
import tv.porst.swfretools.parser.structures.OptionDetailList;

/**
 * Node that represents a OptionDetailList object in the Flash tree.
 */
public final class FlashOptionDetailListNode extends FlashTreeNode<OptionDetailList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashOptionDetailListNode(final String name, final OptionDetailList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
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