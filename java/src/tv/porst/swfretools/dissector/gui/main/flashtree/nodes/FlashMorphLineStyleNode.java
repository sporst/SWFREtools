package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.MorphLineStyle;

public class FlashMorphLineStyleNode extends FlashTreeNode<MorphLineStyle> {

	public FlashMorphLineStyleNode(final String name, final MorphLineStyle lineStyle) {
		super(name, lineStyle);

		createChildren();
	}

	private void createChildren() {
		addNode("StartWidth", getUserObject().getStartWidth());
		addNode("EndWidth", getUserObject().getEndWidth());
		addNode("StartColor", getUserObject().getStartColor());
		addNode("EndColor", getUserObject().getEndColor());
	}

	@Override
	public String toString() {
		return String.format("%s : MORPHLINESTYLE", getName());
	}
}
