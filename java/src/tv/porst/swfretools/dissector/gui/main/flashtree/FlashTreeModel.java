package tv.porst.swfretools.dissector.gui.main.flashtree;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import tv.porst.swfretools.dissector.gui.main.flashtree.nodes.FlashFileNode;
import tv.porst.swfretools.dissector.gui.main.flashtree.nodes.FlashTreeRootNode;
import tv.porst.swfretools.dissector.gui.main.models.FileModel;
import tv.porst.swfretools.dissector.gui.main.models.IFileModelListener;
import tv.porst.swfretools.dissector.gui.main.models.LoadedFile;

/**
 * Tree model of the Flash tree.
 */
public final class FlashTreeModel extends DefaultTreeModel {

	/**
	 * Model that keeps track of open files.
	 */
	private final FileModel fileModel;

	/**
	 * Listener that keeps track of changes in open files.
	 */
	private final IFileModelListener internalFileModelListener = new InternalFileModelListener();

	/**
	 * Creates a new tree model.
	 * 
	 * @param fileModel Model that keeps track of open files.
	 */
	public FlashTreeModel(final FileModel fileModel) {
		super(new FlashTreeRootNode());

		this.fileModel = fileModel;

		fileModel.addListener(internalFileModelListener);
	}

	/**
	 * Frees allocated resources.
	 */
	public void dispose() {
		fileModel.removeListener(internalFileModelListener);
	}

	/**
	 * Listener that keeps track of changes in open files.
	 */
	private class InternalFileModelListener implements IFileModelListener {

		@Override
		public void openedFile(final FileModel fileModel, final LoadedFile file) {

			final DefaultMutableTreeNode root = (DefaultMutableTreeNode) getRoot();

			insertNodeInto(new FlashFileNode(file), root, 0);
		}
	}
}