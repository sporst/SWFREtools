package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.SceneName;
import tv.porst.swfretools.parser.structures.SceneNameList;

public class FlashSceneNameListNode extends FlashTreeNode<SceneNameList> {

	public FlashSceneNameListNode(final String name, final SceneNameList list) {
		super(name, list);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final SceneName sceneName : getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), sceneName);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : SCENENAMELIST", getName());
	}
}
