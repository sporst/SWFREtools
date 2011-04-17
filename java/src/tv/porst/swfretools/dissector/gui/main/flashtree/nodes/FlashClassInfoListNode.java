package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ClassInfo;
import tv.porst.swfretools.parser.structures.ClassInfoList;

/**
 * Node that represents a ClassInfoList object in the Flash tree.
 */
public final class FlashClassInfoListNode extends FlashTreeNode<ClassInfoList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashClassInfoListNode(final String name, final ClassInfoList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final ClassInfo element: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), element);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : class_info[%d]", getName(), getUserObject().size());
	}
}