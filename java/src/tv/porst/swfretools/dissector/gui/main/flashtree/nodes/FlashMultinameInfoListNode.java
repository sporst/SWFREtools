package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.MultinameInfo;
import tv.porst.swfretools.parser.structures.MultinameInfoList;

/**
 * Node that represents a MultinameInfoList object in the Flash tree.
 */
public final class FlashMultinameInfoListNode extends FlashTreeNode<MultinameInfoList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashMultinameInfoListNode(final String name, final MultinameInfoList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final MultinameInfo multinameInfo: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), multinameInfo);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : multiname_info[%d]", getName(), getUserObject().size());
	}
}