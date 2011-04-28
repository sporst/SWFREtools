package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.panels.IExtraPanel;
import tv.porst.swfretools.dissector.gui.main.panels.NamespaceInfoListPanel;
import tv.porst.swfretools.parser.structures.NamespaceInfo;
import tv.porst.swfretools.parser.structures.NamespaceInfoList;
import tv.porst.swfretools.parser.structures.StringInfoList;

/**
 * Node that represents a MultinameInfo object in the Flash tree.
 */
public final class FlashNamespaceInfoListNode extends FlashTreeNode<NamespaceInfoList> {

	private IExtraPanel panel;

	private final StringInfoList constantPool;

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashNamespaceInfoListNode(final String name, final NamespaceInfoList value, final StringInfoList constantPool) {
		super(name, value);

		this.constantPool = constantPool;

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final NamespaceInfo namespaceInfo: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), namespaceInfo);

			counter++;
		}
	}

	/**
	 * Returns the panel to be shown when the node is selected.
	 * 
	 * @return The panel to be shown.
	 */
	@Override
	public IExtraPanel getExtraPanel() {

		if (panel == null) {
			panel = new NamespaceInfoListPanel(getUserObject(), constantPool);
		}

		return panel;
	}

	@Override
	public String toString() {
		return String.format("%s : namespace_info[%d]", getName(), getUserObject().size());
	}
}