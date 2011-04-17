package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ScriptInfo;
import tv.porst.swfretools.parser.structures.ScriptInfoList;

/**
 * Node that represents a ScriptInfoList object in the Flash tree.
 */
public final class FlashScriptInfoListNode extends FlashTreeNode<ScriptInfoList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashScriptInfoListNode(final String name, final ScriptInfoList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final ScriptInfo element: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), element);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : script_info[%d]", getName(), getUserObject().size());
	}
}