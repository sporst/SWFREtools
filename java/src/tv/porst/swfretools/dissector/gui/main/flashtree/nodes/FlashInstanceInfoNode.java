package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.InstanceInfo;

/**
 * Node that represents an InstanceInfo object in the Flash tree.
 */
public final class FlashInstanceInfoNode extends FlashTreeNode<InstanceInfo> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashInstanceInfoNode(final String name, final InstanceInfo value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("name", getUserObject().getName());
		addNode("super_name", getUserObject().getSuperName());
		addNode("flags", getUserObject().getFlags());
		addNode("protected_ns", getUserObject().getProtectedNs());
		addNode("interface_count", getUserObject().getInterfaceCount());
		addNode("interfaces", getUserObject().getInterfaces());
		addNode("iinit", getUserObject().getIinit());
		addNode("trait_count", getUserObject().getTraitCount());
		addNode("traits", getUserObject().getTraits());
	}

	@Override
	public String toString() {
		return String.format("%s : instance_info", getName());
	}
}