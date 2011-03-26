package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.ClassInfo;
import tv.porst.swfretools.parser.structures.ClassInfoList;

public class FlashClassInfoListNode extends FlashTreeNode<ClassInfoList> {

	public FlashClassInfoListNode(final String name, final ClassInfoList encodedList) {
		super(name, encodedList);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final ClassInfo element: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), element);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : class_info[%d]", getName(), getUserObject().size());
	}
}
