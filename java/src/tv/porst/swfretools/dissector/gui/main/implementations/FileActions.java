package tv.porst.swfretools.dissector.gui.main.implementations;

import java.awt.Window;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTree;
import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeHelpers;
import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.dissector.gui.main.models.FileModel;
import tv.porst.swfretools.dissector.gui.main.models.LoadedFile;
import tv.porst.swfretools.parser.SWFParserException;

public class FileActions {

	public static void openFile(final Window parent, final FlashTree tree, final FileModel model) {


		if (true) {
			try {
				//				final LoadedFile loadedFile = model.openFile(new File("C:\\@@\\flash\\oldgems.swf"));
				final LoadedFile loadedFile = model.openFile(new File("C:\\@@\\preloader.swf"));

				final FlashTreeNode node = FlashTreeHelpers.findNode((FlashTreeNode) tree.getModel().getRoot(), loadedFile);

				final TreeNode[] path = node.getPath();

				tree.expandPath(new TreePath(path));
				tree.setSelectionPath(new TreePath(path));

				tree.updateUI();

			} catch (final IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (final SWFParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}

		final JFileChooser chooser = new JFileChooser();

		chooser.setCurrentDirectory(new File("C:\\@@\\flash"));

		if (JFileChooser.APPROVE_OPTION == chooser.showOpenDialog(parent)) {

			final File file = chooser.getSelectedFile();

			try {
				model.openFile(file);
			} catch (final IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (final SWFParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
