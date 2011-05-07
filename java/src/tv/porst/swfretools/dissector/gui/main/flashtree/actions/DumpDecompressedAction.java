package tv.porst.swfretools.dissector.gui.main.flashtree.actions;

import java.awt.Window;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import tv.porst.swfretools.dissector.gui.main.flashtree.implementations.FlashTreeImplementations;
import tv.porst.swfretools.dissector.gui.main.models.LoadedFile;

/**
 * Action that is used to dump decompressed SWF files to a file.
 */
public final class DumpDecompressedAction extends AbstractAction {

	/**
	 * Parent window used for dialogs.
	 */
	private final Window parent;

	/**
	 * The loaded file whose decompressed data is dumped to disk.
	 */
	private final LoadedFile loadedFile;

	/**
	 * Creates a new action object.
	 * 
	 * @param parent Parent window used for dialogs.
	 * @param loadedFile The loaded file whose decompressed data is dumped to disk.
	 */
	public DumpDecompressedAction(final Window parent, final LoadedFile loadedFile) {
		super("Dump decompressed data");

		if (parent == null) {
			throw new IllegalArgumentException("Parent argument must not be null.");
		}

		if (loadedFile == null) {
			throw new IllegalArgumentException("Loaded file argument must not be null.");
		}

		this.parent = parent;
		this.loadedFile = loadedFile;
	}

	@Override
	public void actionPerformed(final ActionEvent event) {
		FlashTreeImplementations.dumpDecompressedFile(parent, loadedFile);
	}
}