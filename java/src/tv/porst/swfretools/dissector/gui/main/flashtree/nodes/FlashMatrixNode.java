package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.Matrix;

/**
 * Node that represents a Matrix object in the Flash tree.
 */
public final class FlashMatrixNode extends FlashTreeNode<Matrix> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashMatrixNode(final String name, final Matrix value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("HasScale", getUserObject().getHasScale());
		addNode("NScaleBits", getUserObject().getnScaleBits());
		addNode("ScaleX", getUserObject().getScaleX());
		addNode("ScaleY", getUserObject().getScaleY());
		addNode("HasRotate", getUserObject().getHasRotate());
		addNode("NRotateBits", getUserObject().getnRotateBits());
		addNode("RotateSkew0", getUserObject().getRotateSkew0());
		addNode("RotateSkew1", getUserObject().getRotateSkew1());
		addNode("NTranslateBits", getUserObject().getnTranslateBits());
		addNode("TranslateX", getUserObject().getTranslateX());
		addNode("TranslateY", getUserObject().getTranslateY());
	}

	@Override
	public String toString() {
		return String.format("%s : MATRIX", getName());
	}
}