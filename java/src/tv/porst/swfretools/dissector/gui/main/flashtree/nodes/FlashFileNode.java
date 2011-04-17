package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import javax.swing.ImageIcon;

import tv.porst.swfretools.dissector.Main;
import tv.porst.swfretools.dissector.gui.main.models.LoadedFile;
import tv.porst.swfretools.parser.tags.Tag;

/**
 * Node that represents a whole SWF file in the Flash tree.
 */
public final class FlashFileNode extends FlashTreeNode<FlashFileNodeWrapper> {

	/**
	 * The loaded file represented by the node.
	 */
	private final LoadedFile file;

	/**
	 * Creates a new node object.
	 * 
	 * @param file The loaded file represented by the node.
	 */
	public FlashFileNode(final LoadedFile file) {
		super(null, new FlashFileNodeWrapper(file));

		this.file = file;

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		for (final Tag tag : file.getSWFFile().getTags()) {
			add(new FlashTagNode(tag));
		}
	}

	@Override
	public ImageIcon getIcon() {
		return new ImageIcon(Main.class.getResource("resources/flashicon.png"));
	}

	@Override
	public String toString() {
		return file.getFile().getAbsolutePath();
	}
}