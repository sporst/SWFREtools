package tv.porst.swfretools.dissector.gui.main.flashtree;

import javax.swing.JTree;
import javax.swing.SwingUtilities;

import tv.porst.swfretools.dissector.gui.main.flashtree.menus.FlashAnyNodeMenu;
import tv.porst.swfretools.dissector.gui.main.flashtree.menus.FlashFileNodeMenu;
import tv.porst.swfretools.dissector.gui.main.flashtree.nodes.FlashFileNode;
import tv.porst.swfretools.dissector.gui.main.flashtree.nodes.FlashTreeNode;
import tv.porst.swfretools.dissector.gui.main.models.LoadedFile;

/**
 * Contains methods for handling clicks on the tree that shows the SWF
 * elements.
 */
public final class FlashTreeNodeClickHandler {

	/**
	 * Handles right-clicks on nodes in the Flash tree.
	 * 
	 * @param tree The tree the clicked node belongs to.
	 * @param node Clicked node.
	 * @param x X-coordinate of the click.
	 * @param y Y-coordinate of the click.
	 */
	public static void handleRightClick(final JTree tree, final FlashTreeNode<?> node, final int x, final int y) {

		if (node == null) {
			throw new IllegalArgumentException("Node argument must not be null.");
		}

		final LoadedFile loadedFile = FlashTreeHelpers.getLoadedFile(node);

		if (node instanceof FlashFileNode) {
			final FlashFileNodeMenu menu = new FlashFileNodeMenu(SwingUtilities.getWindowAncestor(tree), loadedFile);

			menu.show(tree, x, y);
		}
		else {
			final FlashAnyNodeMenu menu = new FlashAnyNodeMenu(SwingUtilities.getWindowAncestor(tree), loadedFile, node);

			menu.show(tree, x, y);
		}
	}

}
