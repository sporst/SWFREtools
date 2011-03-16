package tv.porst.swfretools.dissector.gui.main.models;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.general.ListenerProvider;
import tv.porst.swfretools.parser.SWFParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.SWFFile;

public final class FileModel {

	private final ListenerProvider<IFileModelListener> listeners = new ListenerProvider<IFileModelListener>();

	private final List<LoadedFile> openFiles = new ArrayList<LoadedFile>();

	public void addListener(final IFileModelListener listener) {
		listeners.add(listener);
	}

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

	public void removeListener(final IFileModelListener listener) {
		listeners.remove(listener);
	}
}
