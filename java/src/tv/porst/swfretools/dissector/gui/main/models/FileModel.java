package tv.porst.swfretools.dissector.gui.main.models;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.general.ListenerProvider;
import tv.porst.swfretools.parser.SWFParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.SWFFile;

/**
 * Model that keeps track of open files.
 */
public final class FileModel {

	/**
	 * Currently open files.
	 */
	private final List<LoadedFile> openFiles = new ArrayList<LoadedFile>();

	/**
	 * Listeners that are notified about changes in open files.
	 */
	private final ListenerProvider<IFileModelListener> listeners = new ListenerProvider<IFileModelListener>();

	/**
	 * Adds a new listener that is notified about changes in open files.
	 * 
	 * @param listener The listener object to add.
	 */
	public void addListener(final IFileModelListener listener) {
		listeners.add(listener);
	}

	/**
	 * Opens a new file.
	 * 
	 * @param file The file to open.
	 * 
	 * @return Structure that represents the newly opened file.
	 * 
	 * @throws IOException Thrown if the file could not be read.
	 * @throws SWFParserException Thrown if the file could not be parsed.
	 */
	public LoadedFile openFile(final File file) throws IOException, SWFParserException {

		final SWFFile swfFile = SWFParser.parse(file);

		final LoadedFile loadedFile = new LoadedFile(file, swfFile);

		openFiles.add(loadedFile);

		for (final IFileModelListener listener : listeners) {

			try {
				listener.openedFile(this, loadedFile);
			}
			catch (final Exception exception) {
				exception.printStackTrace();
			}
		}

		return loadedFile;
	}

	/**
	 * Removes a listener object that was previously listening on this model.
	 * 
	 * @param listener The listener object to remove.
	 */
	public void removeListener(final IFileModelListener listener) {
		listeners.remove(listener);
	}
}