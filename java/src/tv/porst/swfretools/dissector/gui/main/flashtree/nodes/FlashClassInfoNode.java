package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ClassInfo;

/**
 * Node that represents a ClassInfo object in the Flash tree.
 */
public final class FlashClassInfoNode extends FlashTreeNode<ClassInfo> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashClassInfoNode(final String name, final ClassInfo value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("cinit", getUserObject().getcInit());
		addNode("trait_count", getUserObject().getTraitCount());
		addNode("traits", getUserObject().getTraits());
	}

	@Override
	public String toString() {
		return String.format("%s : class_info", getName());
	}
}