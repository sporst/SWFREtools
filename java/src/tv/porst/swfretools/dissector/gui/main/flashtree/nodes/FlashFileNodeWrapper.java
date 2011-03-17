package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.swfretools.dissector.gui.main.models.LoadedFile;

public class FlashFileNodeWrapper implements IFileElement {

	private final LoadedFile file;

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

	public LoadedFile getLoadedFile() {
		return file;
	}

}
