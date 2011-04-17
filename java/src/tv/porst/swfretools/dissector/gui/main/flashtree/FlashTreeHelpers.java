package tv.porst.swfretools.dissector.gui.main.flashtree;

import tv.porst.swfretools.dissector.gui.main.flashtree.nodes.FlashFileNode;
import tv.porst.swfretools.dissector.gui.main.flashtree.nodes.FlashFileNodeWrapper;
import tv.porst.swfretools.dissector.gui.main.flashtree.nodes.FlashTreeNode;
import tv.porst.swfretools.dissector.gui.main.models.LoadedFile;

/**
 * Contains methods for working with FlashTree objects.
 */
public final class FlashTreeHelpers {

	/**
	 * Finds a node in the Flash tree.
	 * 
	 * @param root The root node where the search starts.
	 * @param userObject The user object to search for in the nodes.
	 * 
	 * @return The node that represents the given user object or null if there is no such node.
	 */
	public static FlashTreeNode<?> findNode(final FlashTreeNode<?> root, final Object userObject) {

		if (root.getUserObject() == userObject) {
			return root;
		}

		if (root.getUserObject() instanceof FlashFileNodeWrapper && userObject instanceof LoadedFile) {
			if (((FlashFileNodeWrapper)root.getUserObject()).getLoadedFile() == userObject) {
				return root;
			}
		}

		for (int i = 0; i < root.getChildCount(); i++) {

			final FlashTreeNode<?> child = (FlashTreeNode<?>) root.getChildAt(i);

			final FlashTreeNode<?> foundNode = findNode(child, userObject);

			if (foundNode != null) {
				return foundNode;
			}
		}

		return null;
	}

	/**
	 * Returns the SWF file a node belongs to.
	 * 
	 * @param node The node in question.
	 * 
	 * @return The file the node belongs to.
	 */
	public static LoadedFile getLoadedFile(final FlashTreeNode<?> node) {

		if (node instanceof FlashFileNode) {
			return ((FlashFileNode) node).getFile();
		}

		return getLoadedFile((FlashTreeNode<?>) node.getParent());
	}
}
