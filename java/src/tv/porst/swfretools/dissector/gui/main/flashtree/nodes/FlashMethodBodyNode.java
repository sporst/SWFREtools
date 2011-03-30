package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.MethodBody;

public class FlashMethodBodyNode extends FlashTreeNode<MethodBody> {

	public FlashMethodBodyNode(final String name, final MethodBody methodBody) {
		super(name, methodBody);

		createChildren();
	}

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
