package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ExceptionInfo;

/**
 * Node that represents an ExceptionInfo object in the Flash tree.
 */
public final class FlashExceptionInfoNode extends FlashTreeNode<ExceptionInfo> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashExceptionInfoNode(final String name, final ExceptionInfo value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("from", getUserObject().getFrom());
		addNode("to", getUserObject().getTo());
		addNode("target", getUserObject().getTarget());
		addNode("exc_type", getUserObject().getExcType());
		addNode("var_name", getUserObject().getVarName());
	}

	@Override
	public String toString() {
		return String.format("%s : exception_info", getName());
	}
}