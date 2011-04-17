package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.NamespaceInfo;
import tv.porst.swfretools.parser.structures.NamespaceInfoList;

public class FlashNamespaceInfoListNode extends FlashTreeNode<NamespaceInfoList> {

	public FlashNamespaceInfoListNode(final String name, final NamespaceInfoList encodedList) {
		super(name, encodedList);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final NamespaceInfo namespaceInfo: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), namespaceInfo);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : namespace_info[%d]", getName(), getUserObject().size());
	}
}
