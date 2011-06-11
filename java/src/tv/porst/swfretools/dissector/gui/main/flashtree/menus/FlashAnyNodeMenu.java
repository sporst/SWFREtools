package tv.porst.swfretools.dissector.gui.main.flashtree.menus;

import java.awt.Window;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import tv.porst.swfretools.dissector.gui.main.flashtree.actions.DumpElementAction;
import tv.porst.swfretools.dissector.gui.main.flashtree.nodes.FlashTreeNode;
import tv.porst.swfretools.dissector.gui.main.models.LoadedFile;

/**
 * Popup menu that is shown when the user right-clicks on a node that does not
 * have a more specific menu.
 */
public final class FlashAnyNodeMenu extends JPopupMenu {

	/**
	 * Creates a new menu object.
	 * 
	 * @param parent Parent window used for dialogs.
	 * @param loadedFile The loaded file.
	 * @param node The clicked node.
	 */
	public FlashAnyNodeMenu(final Window parent, final LoadedFile loadedFile, final FlashTreeNode<?> node) {

		if (parent == null) {
			throw new IllegalArgumentException("Parent argument must not be null.");
		}

		if (loadedFile == null) {
			throw new IllegalArgumentException("Loaded file argument must not be null.");
		}

		if (node == null) {
			throw new IllegalArgumentException("Node argument must not be null.");
		}

		add(new JMenuItem(new DumpElementAction(parent, loadedFile, node.getUserObject())));
	}

}
