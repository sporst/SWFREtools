package tv.porst.swfretools.dissector.gui.main.flashtree;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import tv.porst.swfretools.dissector.gui.main.flashtree.nodes.FlashFileNode;
import tv.porst.swfretools.dissector.gui.main.models.FileModel;
import tv.porst.swfretools.dissector.gui.main.models.IFileModelListener;
import tv.porst.swfretools.dissector.gui.main.models.LoadedFile;

public class FlashTreeModel extends DefaultTreeModel {

	private final FileModel fileModel;

	private final IFileModelListener internalFileModelListener = new InternalFileModelListener();

	public FlashTreeModel(final FileModel fileModel) {
		super(new FlashTreeRootNode());

		this.fileModel = fileModel;

		fileModel.addListener(internalFileModelListener);
	}

	private class InternalFileModelListener implements IFileModelListener {

		@Override
		public void openedFile(final FileModel fileModel, final LoadedFile file) {

			final DefaultMutableTreeNode root = (DefaultMutableTreeNode) getRoot();

			insertNodeInto(new FlashFileNode(file), root, 0);

			System.out.println("Foo");
		}
	}
}