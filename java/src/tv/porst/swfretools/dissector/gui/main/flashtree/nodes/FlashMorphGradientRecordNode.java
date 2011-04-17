package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.MorphGradientRecord;

/**
 * Node that represents a MorphGradientRecord object in the Flash tree.
 */
public final class FlashMorphGradientRecordNode extends FlashTreeNode<MorphGradientRecord> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashMorphGradientRecordNode(final String name, final MorphGradientRecord value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("StartRatio", getUserObject().getStartRatio());
		addNode("StartColor", getUserObject().getStartColor());
		addNode("EndRatio", getUserObject().getEndRatio());
		addNode("EndColor", getUserObject().getEndColor());
	}

	@Override
	public String toString() {
		return String.format("%s : MORPHGRADIENTRECORD", getName());
	}
}