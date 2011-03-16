package tv.porst.swfretools.dissector.gui.main.flashtree;

import tv.porst.swfretools.dissector.gui.main.flashtree.nodes.FlashFileNode;
import tv.porst.swfretools.dissector.gui.main.models.LoadedFile;

public class FlashTreeHelpers {

	public static FlashTreeNode findNode(final FlashTreeNode root, final Object userObject) {

		if (root.getUserObject() == userObject) {
			return root;
		}

		for (int i = 0; i < root.getChildCount(); i++) {

			final FlashTreeNode child = (FlashTreeNode) root.getChildAt(i);

			final FlashTreeNode foundNode = findNode(child, userObject);

			if (foundNode != null) {
				return foundNode;
			}
		}

		return null;
	}

	public static LoadedFile getLoadedFile(final FlashTreeNode node) {

		if (node instanceof FlashFileNode) {
			return ((FlashFileNode) node).getFile();
		}

		return getLoadedFile((FlashTreeNode) node.getParent());
	}
}
