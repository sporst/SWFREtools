package tv.porst.swfretools.dissector.gui.main;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTree;
import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeModel;
import tv.porst.swfretools.dissector.gui.main.models.FileModel;

public class TreePanel extends JPanel {

	private final FlashTree tree;

	public TreePanel(final FileModel fileModel) {

		super(new BorderLayout());

		final FlashTreeModel model = new FlashTreeModel(fileModel);

		tree = new FlashTree(model);

		add(new JScrollPane(tree));

		setPreferredSize(new Dimension(250, 200));
	}

	public FlashTree getTree() {
		return tree;
	}
}
