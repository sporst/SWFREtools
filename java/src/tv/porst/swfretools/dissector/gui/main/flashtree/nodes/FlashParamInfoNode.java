package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ParamInfo;

/**
 * Node that represents a ParamInfo object in the Flash tree.
 */
public final class FlashParamInfoNode extends FlashTreeNode<ParamInfo> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashParamInfoNode(final String name, final ParamInfo value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("param_names", getUserObject().getParamNames());
	}

	@Override
	public String toString() {
		return String.format("%s : param_info", getName());
	}
}