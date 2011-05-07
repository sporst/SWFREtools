package tv.porst.swfretools.dissector.gui;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

import net.iharder.dnd.FileDrop;
import tv.porst.swfretools.dissector.gui.main.DetailPanel;
import tv.porst.swfretools.dissector.gui.main.TreePanel;
import tv.porst.swfretools.dissector.gui.main.actions.OpenAction;
import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTree;
import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNodeClickHandler;
import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNodeSelectionHandler;
import tv.porst.swfretools.dissector.gui.main.flashtree.nodes.FlashTreeNode;
import tv.porst.swfretools.dissector.gui.main.implementations.FileActions;
import tv.porst.swfretools.dissector.gui.main.models.FileModel;

/**
 * Main window of Flash Dissector.
 */
public final class MainWindow extends JFrame {

	/**
	 * Tree panel that shows the structures of the loaded SWF files.
	 */
	private final TreePanel panel;

	/**
	 * Selection listener that updates the GUI when a new node in the
	 * tree panel was activated.
	 */
	private final TreeSelectionListener internalTreeSelectionListener = new InternalTreeSelectionListener();

	/**
	 * Mouse listener that handles clicks on nodes.
	 */
	private final MouseListener internalTreeClickListener = new InternalTreeClickListener();

	/**
	 * Panel that is shown on the right-hand side of the window.
	 */
	private final DetailPanel detailPanel = new DetailPanel();

	/**
	 * Creates a new main window object.
	 */
	public MainWindow() {
		super("Flash Dissector");

		setLayout(new BorderLayout());

		add(detailPanel);

		final FileModel fileModel = new FileModel();

		panel = new TreePanel(fileModel);

		final FlashTree tree = panel.getTree();
		tree.addTreeSelectionListener(internalTreeSelectionListener);
		tree.addMouseListener(internalTreeClickListener);

		add(panel, BorderLayout.WEST);

		// Add Drag & Drop capabilities to the panel to make it easier to open files.
		new FileDrop(panel, new FileDrop.Listener() {
			@Override
			public void filesDropped(final File[] files) {
				for (final File file : files) {
					FileActions.openFile(tree, fileModel, file);
				}
			}
		});

		final JMenuBar menuBar = new JMenuBar();

		final JMenu menu = new JMenu("File");

		menu.add(new OpenAction(tree, fileModel));

		menuBar.add(menu);

		setJMenuBar(menuBar);

		setSize(900, 600);
		setLocationRelativeTo(null);
	}

	/**
	 * Handles clicks on tree nodes.
	 */
	private final class InternalTreeClickListener extends MouseAdapter {

		/**
		 * Handles right-clicks on tree nodes.
		 * 
		 * @param e Mouse event created by the right-click.
		 */
		private void handleRightClick(final MouseEvent e) {

			final int x = e.getX();
			final int y = e.getY();

			final JTree tree = (JTree)e.getSource();
			final TreePath path = tree.getPathForLocation(x, y);

			if (path == null) {
				return;
			}

			tree.setSelectionPath(path);

			final FlashTreeNode<?> node = (FlashTreeNode<?>)path.getLastPathComponent();

			FlashTreeNodeClickHandler.handleRightClick(tree, node, x, y);
		}

		@Override
		public void mousePressed(final MouseEvent e) {
			if (e.isPopupTrigger()) {
				handleRightClick(e);
			}
		}
		@Override
		public void mouseReleased(final MouseEvent e) {
			if (e.isPopupTrigger()) {
				handleRightClick(e);
			}
		}
	}

	/**
	 * Selection listener that updates the GUI when a new node in the
	 * tree panel was activated.
	 */
	private class InternalTreeSelectionListener implements TreeSelectionListener {

		@Override
		public void valueChanged(final TreeSelectionEvent e) {

			final FlashTreeNode<?> node = (FlashTreeNode<?>) panel.getTree().getLastSelectedPathComponent();

			FlashTreeNodeSelectionHandler.handleSelection(node, detailPanel);
		}
	}
}