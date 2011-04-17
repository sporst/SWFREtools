package tv.porst.swfretools.dissector.gui.main;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTree;
import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeModel;
import tv.porst.swfretools.dissector.gui.main.models.FileModel;

/**
 * Panel that contains the tree where the SWF file structures are shown.
 */
public final class TreePanel extends JPanel {

	/**
	 * Tree where the SWF file structures are shown.
	 */
	private final FlashTree tree;

	/**
	 * Creates a new tree panel object.
	 * 
	 * @param fileModel Model that holds information about open files.
	 */
	public TreePanel(final FileModel fileModel) {
		super(new BorderLayout());

		if (fileModel == null) {
			throw new IllegalArgumentException("File model argument must not be null.");
		}

		final FlashTreeModel model = new FlashTreeModel(fileModel);

		tree = new FlashTree(model);

		add(new JScrollPane(tree));

		setPreferredSize(new Dimension(250, 200));
	}

	/**
	 * Returns the SWF structure tree.
	 * 
	 * @return The SWF structure tree.
	 */
	public FlashTree getTree() {
		return tree;
	}
}