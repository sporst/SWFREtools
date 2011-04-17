package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.MethodInfo;

public class FlashMethodInfoNode extends FlashTreeNode<MethodInfo> {

	public FlashMethodInfoNode(final String name, final MethodInfo methodInfo) {
		super(name, methodInfo);

		createChildren();
	}

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
