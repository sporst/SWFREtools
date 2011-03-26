package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.ClassInfo;

public class FlashClassInfoNode extends FlashTreeNode<ClassInfo> {

	public FlashClassInfoNode(final String name, final ClassInfo classInfo) {
		super(name, classInfo);

		createChildren();
	}

	private void createChildren() {
		addNode("cinit", getUserObject().getcInit());
		addNode("trait_count", getUserObject().getTraitCount());
		addNode("traits", getUserObject().getTraits());
	}

	@Override
	public String toString() {
		return String.format("%s : class_info", getName());
	}
}
