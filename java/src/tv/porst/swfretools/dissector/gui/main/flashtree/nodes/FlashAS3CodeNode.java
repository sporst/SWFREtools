package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import javax.swing.JPanel;

import tv.porst.swfretools.dissector.gui.main.panels.AS3CodePanel;
import tv.porst.swfretools.parser.structures.AS3Code;

/**
 * Node that represents a ActionScript code node object in the Flash tree.
 */
public final class FlashAS3CodeNode extends FlashTreeNode<AS3Code> {

	/**
	 * Panel to be shown when the node is selected.
	 */
	private JPanel panel;

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashAS3CodeNode(final String name, final AS3Code value) {
		super(name, value);
	}

	/**
	 * Returns the panel to be shown when the node is selected.
	 * 
	 * @return The panel to be shown.
	 */
	public JPanel getExtraPanel() {

		if (panel == null) {
			panel = new AS3CodePanel(getUserObject());
		}

		return panel;
	}

	@Override
	public String toString() {
		return String.format("%s : code", getName());
	}
}