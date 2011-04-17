package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ScriptInfo;

public class FlashScriptInfoNode extends FlashTreeNode<ScriptInfo> {

	public FlashScriptInfoNode(final String name, final ScriptInfo scriptInfo) {
		super(name, scriptInfo);

		createChildren();
	}

	private void createChildren() {
		addNode("init", getUserObject().getInit());
		addNode("trait_count", getUserObject().getTraitCount());
		addNode("traits", getUserObject().getTraits());
	}

	@Override
	public String toString() {
		return String.format("%s : script_info", getName());
	}
}
