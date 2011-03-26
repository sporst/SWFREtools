package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.MultinameInfo;
import tv.porst.swfretools.parser.structures.MultinameInfoList;

public class FlashMultinameInfoListNode extends FlashTreeNode<MultinameInfoList> {

	public FlashMultinameInfoListNode(final String name, final MultinameInfoList encodedList) {
		super(name, encodedList);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final MultinameInfo multinameInfo: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), multinameInfo);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : multiname_info[%d]", getName(), getUserObject().size());
	}
}
