package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.SceneName;

/**
 * Node that represents a SceneName object in the Flash tree.
 */
public final class FlashSceneNameNode extends FlashTreeNode<SceneName> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashSceneNameNode(final String name, final SceneName value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("Offset", getUserObject().getOffset());
		addNode("Name", getUserObject().getName());
	}

	@Override
	public String toString() {
		return String.format("%s : SCENENAME", getName());
	}
}