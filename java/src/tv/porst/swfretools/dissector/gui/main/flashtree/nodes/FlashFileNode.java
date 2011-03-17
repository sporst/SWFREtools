package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.dissector.gui.main.models.LoadedFile;
import tv.porst.swfretools.parser.tags.Tag;

public class FlashFileNode extends FlashTreeNode {

	private final LoadedFile file;

	public FlashFileNode(final LoadedFile file) {
		super(null, new FlashFileNodeWrapper(file));

		this.file = file;

		createChildren();
	}

	private void createChildren() {

		for (final Tag tag : file.getSWFFile().getTags()) {

			add(new FlashTagNode(tag));

		}
	}

	public LoadedFile getFile() {
		return file;
	}

	@Override
	public String toString() {
		return file.getFile().getAbsolutePath();
	}
}
