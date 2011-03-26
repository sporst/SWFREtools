package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.NamespaceSetInfo;
import tv.porst.swfretools.parser.structures.NamespaceSetInfoList;

public class FlashNamespaceSetInfoListNode extends FlashTreeNode<NamespaceSetInfoList> {

	public FlashNamespaceSetInfoListNode(final String name, final NamespaceSetInfoList encodedList) {
		super(name, encodedList);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final NamespaceSetInfo namespaceSetInfo: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), namespaceSetInfo);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : ns_set_info[%d]", getName(), getUserObject().size());
	}
}
