package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.MethodInfo;
import tv.porst.swfretools.parser.structures.MethodInfoList;

public class FlashMethodInfoListNode extends FlashTreeNode<MethodInfoList> {

	public FlashMethodInfoListNode(final String name, final MethodInfoList encodedList) {
		super(name, encodedList);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final MethodInfo methodInfo: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), methodInfo);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : method_info[%d]", getName(), getUserObject().size());
	}
}
