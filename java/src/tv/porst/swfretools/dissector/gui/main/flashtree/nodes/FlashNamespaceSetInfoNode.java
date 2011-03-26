package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.NamespaceSetInfo;

public class FlashNamespaceSetInfoNode extends FlashTreeNode<NamespaceSetInfo> {

	public FlashNamespaceSetInfoNode(final String name, final NamespaceSetInfo namespaceSetInfo) {
		super(name, namespaceSetInfo);

		createChildren();
	}

	private void createChildren() {
		addNode("Count", getUserObject().getCount());
		addNode("Namespaces", getUserObject().getNamespaces());
	}

	@Override
	public String toString() {
		return String.format("%s : ns_set_info", getName());
	}
}
