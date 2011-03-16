package tv.porst.swfretools.dissector.gui.main.flashtree;

import javax.swing.JTree;

public class FlashTree extends JTree {

	public FlashTree(final FlashTreeModel model) {
		super(model);

		setRootVisible(false);
	}

}
