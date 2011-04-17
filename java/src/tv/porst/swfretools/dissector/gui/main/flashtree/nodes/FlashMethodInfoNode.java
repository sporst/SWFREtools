package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.MethodInfo;

/**
 * Node that represents a MethodInfo object in the Flash tree.
 */
public final class FlashMethodInfoNode extends FlashTreeNode<MethodInfo> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashMethodInfoNode(final String name, final MethodInfo value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("param_count", getUserObject().getParamCount());
		addNode("return_type", getUserObject().getReturnType());
		addNode("param_types", getUserObject().getParamTypes());
		addNode("name", getUserObject().getName());
		addNode("flags", getUserObject().getFlags());
		addNode("option_info", getUserObject().getOptionInfo());
		addNode("param_info", getUserObject().getParamInfo());
	}

	@Override
	public String toString() {
		return String.format("%s : method_info", getName());
	}
}