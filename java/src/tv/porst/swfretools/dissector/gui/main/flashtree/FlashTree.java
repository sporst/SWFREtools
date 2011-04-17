package tv.porst.swfretools.dissector.gui.main.flashtree;

import tv.porst.splib.gui.tree.IconTree;

/**
 * Tree that displays loaded SWF files.
 */
public final class FlashTree extends IconTree {

	/**
	 * Creates a new FlashTree object.
	 * 
	 * @param model The model of the Flash tree.
	 */
	public FlashTree(final FlashTreeModel model) {
		super(model);

		setRootVisible(false);
	}
}