package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.panels.StringInfoListPanel;
import tv.porst.swfretools.parser.structures.StringInfo;
import tv.porst.swfretools.parser.structures.StringInfoList;

/**
 * Node that represents a StringInfoList object in the Flash tree.
 */
public final class FlashStringInfoListNode extends FlashTreeNode<StringInfoList> {

	/**
	 * Panel that is shown when the node is selected.
	 */
	private StringInfoListPanel panel;

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashStringInfoListNode(final String name, final StringInfoList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final StringInfo element: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), element);

			counter++;
		}
	}

	/**
	 * Returns the panel to be shown when the node is selected.
	 * 
	 * @return The panel to be shown.
	 */
	@Override
	public StringInfoListPanel getExtraPanel() {

		if (panel == null) {
			panel = new StringInfoListPanel(getUserObject());
		}

		return panel;
	}

	@Override
	public String toString() {
		return String.format("%s : string_info[%d]", getName(), getUserObject().size());
	}
}