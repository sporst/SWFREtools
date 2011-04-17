package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.InstanceInfo;
import tv.porst.swfretools.parser.structures.InstanceInfoList;

/**
 * Node that represents an InstanceInfoList object in the Flash tree.
 */
public final class FlashInstanceInfoListNode extends FlashTreeNode<InstanceInfoList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashInstanceInfoListNode(final String name, final InstanceInfoList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final InstanceInfo element: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), element);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : instance_info[%d]", getName(), getUserObject().size());
	}
}