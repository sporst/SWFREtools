package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.MethodBody;

/**
 * Node that represents a MethodBody object in the Flash tree.
 */
public final class FlashMethodBodyNode extends FlashTreeNode<MethodBody> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashMethodBodyNode(final String name, final MethodBody value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("method", getUserObject().getMethod());
		addNode("max_stack", getUserObject().getMaxStack());
		addNode("local_count", getUserObject().getLocalCount());
		addNode("init_scope_depth", getUserObject().getInitScopeDepth());
		addNode("max_scope_depth", getUserObject().getMaxScopeDepth());
		addNode("code_length", getUserObject().getCodeLength());
		addNode("code", getUserObject().getCode());
		addNode("exception_count", getUserObject().getExceptionCount());
		addNode("exceptions", getUserObject().getExceptions());
		addNode("trait_count", getUserObject().getTraitCount());
		addNode("traits", getUserObject().getTraits());
	}

	@Override
	public String toString() {
		return String.format("%s : method_body", getName());
	}
}