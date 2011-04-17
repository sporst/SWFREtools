package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.TraitsInfo;
import tv.porst.swfretools.parser.structures.TraitsInfoList;

public class FlashTraitsInfoListNode extends FlashTreeNode<TraitsInfoList> {

	public FlashTraitsInfoListNode(final String name, final TraitsInfoList encodedList) {
		super(name, encodedList);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final TraitsInfo element: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), element);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : traits_info[%d]", getName(), getUserObject().size());
	}
}
