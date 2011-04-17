package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.Float32;
import tv.porst.swfretools.parser.structures.Float32List;

/**
 * Node that represents a Float32Array object in the Flash tree.
 */
public final class FlashFloat32ArrayNode extends FlashTreeNode<Float32List> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashFloat32ArrayNode(final String name, final Float32List value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {

		int counter = 0;

		for (final Float32 value: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), value);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : FLOAT32ARRAY", getName());
	}
}