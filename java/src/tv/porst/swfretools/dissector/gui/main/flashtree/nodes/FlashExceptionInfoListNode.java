package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ExceptionInfo;
import tv.porst.swfretools.parser.structures.ExceptionInfoList;

/**
 * Node that represents an ExceptionInfoList object in the Flash tree.
 */
public final class FlashExceptionInfoListNode extends FlashTreeNode<ExceptionInfoList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashExceptionInfoListNode(final String name, final ExceptionInfoList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final ExceptionInfo element: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), element);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : exception_info[%d]", getName(), getUserObject().size());
	}
}