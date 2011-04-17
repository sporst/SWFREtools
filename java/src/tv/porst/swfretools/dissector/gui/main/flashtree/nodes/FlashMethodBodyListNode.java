package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.MethodBody;
import tv.porst.swfretools.parser.structures.MethodBodyList;

/**
 * Node that represents a MethodBodyList object in the Flash tree.
 */
public final class FlashMethodBodyListNode extends FlashTreeNode<MethodBodyList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashMethodBodyListNode(final String name, final MethodBodyList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final MethodBody element: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), element);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : method_body[%d]", getName(), getUserObject().size());
	}
}