package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.GradRecord3;
import tv.porst.swfretools.parser.structures.GradRecord3List;

/**
 * Node that represents a GradRecord3List object in the Flash tree.
 */
public final class FlashGradRecord3ListNode extends FlashTreeNode<GradRecord3List> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashGradRecord3ListNode(final String name, final GradRecord3List value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final GradRecord3 gradRecord: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), gradRecord);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : GRADRECORDLIST", getName());
	}
}