package tv.porst.swfretools.dissector.gui.main.models;

import java.io.File;

import tv.porst.swfretools.parser.structures.SWFFile;

/**
 * Represents a loaded SWF file.
 */
public final class LoadedFile {

	/**
	 * The input file.
	 */
	private final File file;

	/**
	 * The parsed SWF file.
	 */
	private final SWFFile swfFile;

	/**
	 * Creates a new LoadedFile object.
	 * 
	 * @param file The input file.
	 * @param swfFile The parsed SWF file.
	 */
	public LoadedFile(final File file, final SWFFile swfFile) {

		if (file == null) {
			throw new IllegalArgumentException("File argument must not be null.");
		}

		if (swfFile == null) {
			throw new IllegalArgumentException("Swf file argument must not be null.");
		}

		this.file = file;
		this.swfFile = swfFile;
	}

	/**
	 * Returns the input file.
	 * 
	 * @return The input file.
	 */
	public File getFile() {
		return file;
	}

	/**
	 * Returns the parsed SWF file.
	 * 
	 * @return The parsed SWF file.
	 */
	public SWFFile getSWFFile() {
		return swfFile;
	}
}