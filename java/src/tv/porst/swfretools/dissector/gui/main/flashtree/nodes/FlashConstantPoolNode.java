package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.ConstantPool;

public class FlashConstantPoolNode extends FlashTreeNode<ConstantPool> {

	public FlashConstantPoolNode(final String name, final ConstantPool value) {
		super(name, value);

		createChildren();
	}

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
		addNode("namespace_info", getUserObject().getNamespaces());
		addNode("ns_set_count", getUserObject().getNamespaceSetCount());
		addNode("ns_set_info", getUserObject().getNamespaceSets());
		addNode("multiname_count", getUserObject().getMultinameCount());
		addNode("multiname_info", getUserObject().getMultinames());
	}

	@Override
	public String toString() {
		return String.format("%s : constant_pool", getName());
	}
}
