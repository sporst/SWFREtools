package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.AS3Data;

public class FlashAS3DataNode extends FlashTreeNode<AS3Data> {

	public FlashAS3DataNode(final String name, final AS3Data value) {
		super(name, value);

		createChildren();
	}

	private void createChildren() {
	}

	@Override
	public String toString() {
		return String.format("%s : ACTIONSCRIPT3", getName());
	}
}
