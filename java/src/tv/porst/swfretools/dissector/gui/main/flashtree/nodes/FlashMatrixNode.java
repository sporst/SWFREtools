package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.Matrix;

public class FlashMatrixNode extends FlashTreeNode<Matrix> {

	public FlashMatrixNode(final String name, final Matrix matrix) {
		super(name, matrix);

		createChildren();
	}

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
