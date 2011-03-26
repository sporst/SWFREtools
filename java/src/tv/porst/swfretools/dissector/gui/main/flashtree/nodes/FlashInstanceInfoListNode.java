package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.InstanceInfo;
import tv.porst.swfretools.parser.structures.InstanceInfoList;

public class FlashInstanceInfoListNode extends FlashTreeNode<InstanceInfoList> {

	public FlashInstanceInfoListNode(final String name, final InstanceInfoList encodedList) {
		super(name, encodedList);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final InstanceInfo element: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), element);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : instance_info[%d]", getName(), getUserObject().size());
	}
}
