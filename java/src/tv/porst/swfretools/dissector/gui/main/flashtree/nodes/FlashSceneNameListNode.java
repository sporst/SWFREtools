package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.SceneName;
import tv.porst.swfretools.parser.structures.SceneNameList;

/**
 * Node that represents a SceneNameList object in the Flash tree.
 */
public final class FlashSceneNameListNode extends FlashTreeNode<SceneNameList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashSceneNameListNode(final String name, final SceneNameList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
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