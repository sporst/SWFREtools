package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.splib.binaryparser.Float32;
import tv.porst.swfretools.parser.structures.Float32List;

public class FlashFloat32ArrayNode extends FlashTreeNode<Float32List> {

	public FlashFloat32ArrayNode(final String name, final Float32List floats) {
		super(name, floats);

		createChildren();
	}

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
