package tv.porst.swfretools.dissector.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import tv.porst.swfretools.dissector.gui.main.DetailPanel;
import tv.porst.swfretools.dissector.gui.main.TreePanel;
import tv.porst.swfretools.dissector.gui.main.actions.OpenAction;
import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTree;
import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNodeSelectionHandler;
import tv.porst.swfretools.dissector.gui.main.flashtree.nodes.FlashTreeNode;
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

		add(panel, BorderLayout.WEST);

		final JMenuBar menuBar = new JMenuBar();

		final JMenu menu = new JMenu("File");

		menu.add(new OpenAction(tree, fileModel));

		menuBar.add(menu);

		setJMenuBar(menuBar);

		setSize(800, 600);
		setLocationRelativeTo(null);
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