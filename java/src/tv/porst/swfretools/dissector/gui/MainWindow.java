package tv.porst.swfretools.dissector.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import tv.porst.swfretools.dissector.gui.main.TreePanel;
import tv.porst.swfretools.dissector.gui.main.actions.OpenAction;
import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTree;
import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNodeSelectionHandler;
import tv.porst.swfretools.dissector.gui.main.hexview.FlashHexView;
import tv.porst.swfretools.dissector.gui.main.models.FileModel;

public class MainWindow extends JFrame {

	private final TreeSelectionListener internalTreeSelectionListener = new InternalTreeSelectionListener();
	private final FlashHexView hexView;
	private final TreePanel panel;

	public static void main(final String[] args) {
		final MainWindow window = new MainWindow();

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}


	public MainWindow() {
		super("Flash Dissector");

		setLayout(new BorderLayout());

		hexView = new FlashHexView();

		add(hexView, BorderLayout.CENTER);

		final FileModel fileModel = new FileModel();

		panel = new TreePanel(fileModel);

		final FlashTree tree = panel.getTree();
		tree.addTreeSelectionListener(internalTreeSelectionListener);

		add(panel, BorderLayout.WEST);

		final JMenuBar menuBar = new JMenuBar();

		final JMenu menu = new JMenu("File");

		menu.add(new OpenAction(this, tree, fileModel));

		menuBar.add(menu);

		setJMenuBar(menuBar);

		setSize(800, 600);
		setLocationRelativeTo(null);
	}

	private class InternalTreeSelectionListener implements TreeSelectionListener {

		@Override
		public void valueChanged(final TreeSelectionEvent e) {

			final FlashTreeNode node = (FlashTreeNode) panel.getTree().getLastSelectedPathComponent();

			FlashTreeNodeSelectionHandler.handleSelection(node, hexView);
		}
	}
}
