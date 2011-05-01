package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.panels.IExtraPanel;
import tv.porst.swfretools.dissector.gui.main.panels.MultinameInfoListPanel;
import tv.porst.swfretools.parser.structures.MultinameInfo;
import tv.porst.swfretools.parser.structures.MultinameInfoList;
import tv.porst.swfretools.parser.structures.NamespaceInfoList;
import tv.porst.swfretools.parser.structures.StringInfoList;

/**
 * Node that represents a MultinameInfoList object in the Flash tree.
 */
public final class FlashMultinameInfoListNode extends FlashTreeNode<MultinameInfoList> {

	private IExtraPanel panel;
	private final StringInfoList constantPool;
	private final NamespaceInfoList namespaceList;

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashMultinameInfoListNode(final String name, final MultinameInfoList value, final StringInfoList constantPool, final NamespaceInfoList namespaceList) {
		super(name, value);

		this.constantPool = constantPool;
		this.namespaceList = namespaceList;

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final MultinameInfo multinameInfo: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), multinameInfo);

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
			panel = new MultinameInfoListPanel(getUserObject(), constantPool, namespaceList);
		}

		return panel;
	}

	@Override
	public String toString() {
		return String.format("%s : multiname_info[%d]", getName(), getUserObject().size());
	}
}