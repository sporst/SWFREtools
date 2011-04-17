package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.KerningRecord;
import tv.porst.swfretools.parser.structures.KerningRecordList;

/**
 * Node that represents a KerningRecordList object in the Flash tree.
 */
public final class FlashKerningRecordListNode extends FlashTreeNode<KerningRecordList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashKerningRecordListNode(final String name, final KerningRecordList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final KerningRecord symbol: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), symbol);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : KERNINGRECORDLIST", getName());
	}

}