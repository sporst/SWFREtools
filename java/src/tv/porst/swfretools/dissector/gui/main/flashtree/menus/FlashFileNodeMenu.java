package tv.porst.swfretools.dissector.gui.main.flashtree.menus;

import java.awt.Window;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import tv.porst.swfretools.dissector.gui.main.flashtree.actions.DumpDecompressedAction;
import tv.porst.swfretools.dissector.gui.main.models.LoadedFile;

/**
 * Popup menu that is shown when the user right-clicks a file node in the Flash
 * tree.
 */
public final class FlashFileNodeMenu extends JPopupMenu {

	/**
	 * Creates a new menu object.
	 * 
	 * @param parent Parent window used for dialogs.
	 * @param loadedFile The loaded file represented by the clicked node.
	 */
	public FlashFileNodeMenu(final Window parent, final LoadedFile loadedFile) {

		if (parent == null) {
			throw new IllegalArgumentException("Parent argument must not be null.");
		}

		if (loadedFile == null) {
			throw new IllegalArgumentException("Loaded file argument must not be null.");
		}

		add(new JMenuItem(new DumpDecompressedAction(parent, loadedFile)));
	}

}
