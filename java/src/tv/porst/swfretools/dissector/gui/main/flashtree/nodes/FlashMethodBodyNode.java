package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.panels.AS3CodePanel;
import tv.porst.swfretools.parser.structures.AS3Data;
import tv.porst.swfretools.parser.structures.MethodBody;

/**
 * Node that represents a MethodBody object in the Flash tree.
 */
public final class FlashMethodBodyNode extends FlashTreeNode<MethodBody> {

	/**
	 * Panel to be shown when the node is selected.
	 */
	private AS3CodePanel panel;

	private final AS3Data abcData;

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashMethodBodyNode(final String name, final MethodBody value, final AS3Data abcData) {
		super(name, value);

		this.abcData = abcData;

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

	/**
	 * Returns the panel to be shown when the node is selected.
	 * 
	 * @return The panel to be shown.
	 */
	@Override
	public AS3CodePanel getExtraPanel() {

		if (panel == null) {
			//			panel = new AS3CodePanel(getUserObject(), abcData);
		}

		return panel;
	}

	@Override
	public String toString() {
		return String.format("%s : method_body", getName());
	}
}