package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.swfretools.dissector.gui.main.models.LoadedFile;

/**
 * Wrapper that is used to turn a loaded file structure into a file
 * element so that it can be shown in the Flash structure tree.
 */
public final class FlashFileNodeWrapper implements IFileElement {

	/**
	 * The wrapped loaded file.
	 */
	private final LoadedFile file;

	/**
	 * Creates a new wrapper object.
	 * 
	 * @param file The wrapped loaded file.
	 */
	public FlashFileNodeWrapper(final LoadedFile file) {

		this.file = file;
	}

	@Override
	public int getBitLength() {
		return 0;
	}

	@Override
	public int getBitPosition() {
		return 0;
	}

	/**
	 * Returns the wrapped loaded file.
	 * 
	 * @return The wrapped loaded file.
	 */
	public LoadedFile getLoadedFile() {
		return file;
	}
}