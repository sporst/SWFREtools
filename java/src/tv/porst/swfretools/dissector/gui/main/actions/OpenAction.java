package tv.porst.swfretools.dissector.gui.main.actions;

import java.awt.Window;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTree;
import tv.porst.swfretools.dissector.gui.main.implementations.FileActions;
import tv.porst.swfretools.dissector.gui.main.models.FileModel;

public class OpenAction extends AbstractAction {

	private final Window parent;
	private final FileModel model;
	private final FlashTree tree;

	public OpenAction(final Window parent, final FlashTree tree, final FileModel model) {
		super("Open");

		this.parent = parent;
		this.tree = tree;
		this.model = model;
	}

	@Override
	public void actionPerformed(final ActionEvent event) {
		FileActions.openFile(parent, tree, model);
	}
}