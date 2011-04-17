package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.TraitsInfo;
import tv.porst.swfretools.parser.structures.TraitsInfoList;

/**
 * Node that represents a TraitsInfoList object in the Flash tree.
 */
public final class FlashTraitsInfoListNode extends FlashTreeNode<TraitsInfoList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashTraitsInfoListNode(final String name, final TraitsInfoList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final TraitsInfo element: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), element);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : traits_info[%d]", getName(), getUserObject().size());
	}
}