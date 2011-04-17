package tv.porst.swfretools.dissector.gui.main.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTree;
import tv.porst.swfretools.dissector.gui.main.implementations.FileActions;
import tv.porst.swfretools.dissector.gui.main.models.FileModel;

/**
 * Action used to open new Flash files.
 */
public final class OpenAction extends AbstractAction {

	/**
	 * Flash tree where the open file is shown.
	 */
	private final FlashTree tree;

	/**
	 * File model where the new file is opened.
	 */
	private final FileModel model;

	/**
	 * Creates a new OpenAction object.
	 * 
	 * @param tree Flash tree where the open file is shown.
	 * @param model File model where the new file is opened.
	 */
	public OpenAction(final FlashTree tree, final FileModel model) {
		super("Open");

		if (tree == null) {
			throw new IllegalArgumentException("Tree argument must not be null.");
		}

		if (model == null) {
			throw new IllegalArgumentException("Model argument must not be null.");
		}

		this.tree = tree;
		this.model = model;
	}

	@Override
	public void actionPerformed(final ActionEvent event) {
		FileActions.openFile(tree, model);
	}
}