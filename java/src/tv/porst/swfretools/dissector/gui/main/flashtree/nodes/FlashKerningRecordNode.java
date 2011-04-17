package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.KerningRecord;

/**
 * Node that represents a KerningRecord object in the Flash tree.
 */
public final class FlashKerningRecordNode extends FlashTreeNode<KerningRecord> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashKerningRecordNode(final String name, final KerningRecord value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("FontKerningCode1", getUserObject().getFontKerningCode1());
		addNode("FontKerningCode2", getUserObject().getFontKerningCode2());
		addNode("FontKerningAdjustment", getUserObject().getFontKerningAdjustment());
	}

	@Override
	public String toString() {
		return String.format("%s : KERNINGRECORD", getName());
	}
}