package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.FrameLabel;
import tv.porst.swfretools.parser.structures.FrameLabelList;

/**
 * Node that represents a FrameLabelList object in the Flash tree.
 */
public final class FlashFrameLabelListNode extends FlashTreeNode<FrameLabelList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashFrameLabelListNode(final String name, final FrameLabelList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final FrameLabel frameLabel : getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), frameLabel);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : FRAMELABELLIST", getName());
	}
}