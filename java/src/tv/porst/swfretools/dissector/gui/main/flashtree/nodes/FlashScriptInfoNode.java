package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ScriptInfo;

/**
 * Node that represents a ScriptInfo object in the Flash tree.
 */
public final class FlashScriptInfoNode extends FlashTreeNode<ScriptInfo> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashScriptInfoNode(final String name, final ScriptInfo value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("init", getUserObject().getInit());
		addNode("trait_count", getUserObject().getTraitCount());
		addNode("traits", getUserObject().getTraits());
	}

	@Override
	public String toString() {
		return String.format("%s : script_info", getName());
	}
}