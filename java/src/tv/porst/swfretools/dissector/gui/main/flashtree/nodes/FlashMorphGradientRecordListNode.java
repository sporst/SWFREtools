package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.MorphGradientRecord;
import tv.porst.swfretools.parser.structures.MorphGradientRecordList;

/**
 * Node that represents a MorphGradientRecordList object in the Flash tree.
 */
public final class FlashMorphGradientRecordListNode extends FlashTreeNode<MorphGradientRecordList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashMorphGradientRecordListNode(final String name, final MorphGradientRecordList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final MorphGradientRecord gradient: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), gradient);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : MORPHGRADIENTRECORDLIST", getName());
	}
}