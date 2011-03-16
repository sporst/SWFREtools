package tv.porst.swfretools.dissector.gui.main.models;

import java.io.File;

import tv.porst.swfretools.parser.structures.SWFFile;

public class LoadedFile {

	private final File file;
	private final SWFFile swfFile;

	public LoadedFile(final File file, final SWFFile swfFile) {

		this.file = file;
		this.swfFile = swfFile;
	}

	public File getFile() {
		return file;
	}

	public SWFFile getSWFFile() {
		return swfFile;
	}

}
