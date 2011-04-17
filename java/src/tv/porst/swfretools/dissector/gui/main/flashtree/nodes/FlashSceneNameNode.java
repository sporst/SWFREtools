package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.SceneName;

public class FlashSceneNameNode extends FlashTreeNode<SceneName> {

	public FlashSceneNameNode(final String name, final SceneName sceneName) {
		super(name, sceneName);

		createChildren();
	}

	private void createChildren() {
		addNode("Offset", getUserObject().getOffset());
		addNode("Name", getUserObject().getName());
	}

	@Override
	public String toString() {
		return String.format("%s : SCENENAME", getName());
	}
}
