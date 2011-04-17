package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.NamespaceInfo;

public class FlashNamespaceInfoNode extends FlashTreeNode<NamespaceInfo> {

	public FlashNamespaceInfoNode(final String name, final NamespaceInfo namespaceInfo) {
		super(name, namespaceInfo);

		createChildren();
	}

	private void createChildren() {
		addNode("Kind", getUserObject().getKind());
		addNode("Name", getUserObject().getName());
	}

	@Override
	public String toString() {
		return String.format("%s : namespace_info", getName());
	}
}
