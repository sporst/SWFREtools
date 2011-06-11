package tv.porst.swfretools.dissector.gui.main.flashtree.actions;

import java.awt.Window;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.swfretools.dissector.gui.main.flashtree.implementations.FlashTreeImplementations;
import tv.porst.swfretools.dissector.gui.main.models.LoadedFile;

/**
 * Action that is used to dump SWF elements to a file.
 */
public final class DumpElementAction extends AbstractAction {

	/**
	 * Parent window used for dialogs.
	 */
	private final Window parent;

	/**
	 * The loaded file whose decompressed data is dumped to disk.
	 */
	private final LoadedFile loadedFile;

	/**
	 * The element to dump to a file.
	 */
	private final IFileElement element;

	/**
	 * Creates a new action object.
	 * 
	 * @param parent Parent window used for dialogs.
	 * @param loadedFile The loaded file whose decompressed data is dumped to disk.
	 * @param element The element to dump to a file.
	 */
	public DumpElementAction(final Window parent, final LoadedFile loadedFile, final IFileElement element) {
		super("Dump to file");

		if (parent == null) {
			throw new IllegalArgumentException("Parent argument must not be null.");
		}

		if (loadedFile == null) {
			throw new IllegalArgumentException("Loaded file argument must not be null.");
		}

		if (element == null) {
			throw new IllegalArgumentException("Element argument must not be null.");
		}

		this.parent = parent;
		this.loadedFile = loadedFile;
		this.element = element;
	}

	@Override
	public void actionPerformed(final ActionEvent event) {
		FlashTreeImplementations.dumpElement(parent, loadedFile, element);
	}
}