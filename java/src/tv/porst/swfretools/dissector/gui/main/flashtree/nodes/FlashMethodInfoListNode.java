package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.MethodInfo;
import tv.porst.swfretools.parser.structures.MethodInfoList;

/**
 * Node that represents a MethodInfoList object in the Flash tree.
 */
public final class FlashMethodInfoListNode extends FlashTreeNode<MethodInfoList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashMethodInfoListNode(final String name, final MethodInfoList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final MethodInfo methodInfo: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), methodInfo);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : method_info[%d]", getName(), getUserObject().size());
	}
}