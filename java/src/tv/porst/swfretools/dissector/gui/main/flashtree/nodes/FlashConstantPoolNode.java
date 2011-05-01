package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ConstantPool;

/**
 * Node that represents a ConstantPool object in the Flash tree.
 */
public final class FlashConstantPoolNode extends FlashTreeNode<ConstantPool> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashConstantPoolNode(final String name, final ConstantPool value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("int_count", getUserObject().getIntCount());
		addNode("integer", getUserObject().getIntegers());
		addNode("uint_count", getUserObject().getUintCount());
		addNode("uninteger", getUserObject().getUintegers());
		addNode("double_count", getUserObject().getDoubleCount());
		addNode("double", getUserObject().getDoubles());
		addNode("string_count", getUserObject().getStringCount());
		addNode("string_info", getUserObject().getStrings());
		addNode("namespace_count", getUserObject().getNamespaceCount());
		addNode("namespace_info", getUserObject().getNamespaces(), getUserObject().getStrings());
		addNode("ns_set_count", getUserObject().getNamespaceSetCount());
		addNode("ns_set_info", getUserObject().getNamespaceSets());
		addNode("multiname_count", getUserObject().getMultinameCount());
		addNode("multiname_info", getUserObject().getMultinames(), getUserObject().getStrings(), getUserObject().getNamespaces());
	}

	@Override
	public String toString() {
		return String.format("%s : constant_pool", getName());
	}
}