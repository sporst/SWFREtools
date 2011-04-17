package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.IFileElement;

/**
 * Root node of the Flash tree.
 */
public class FlashTreeRootNode extends FlashTreeNode<IFileElement> {

	/**
	 * Creates a new root node object.
	 */
	public FlashTreeRootNode() {
		super(null, null);
	}
}
