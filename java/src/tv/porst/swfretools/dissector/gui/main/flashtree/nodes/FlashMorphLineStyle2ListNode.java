package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.MorphLineStyle2;
import tv.porst.swfretools.parser.structures.MorphLineStyle2List;

/**
 * Node that represents a MorphLineStyle2List object in the Flash tree.
 */
public final class FlashMorphLineStyle2ListNode extends FlashTreeNode<MorphLineStyle2List> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashMorphLineStyle2ListNode(final String name, final MorphLineStyle2List value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final MorphLineStyle2 lineStyle: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), lineStyle);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : MORPHLINESTYLELIST", getName());
	}
}