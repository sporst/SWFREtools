package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.ButtonRecord2;

public class FlashButtonRecord2Node extends FlashTreeNode<ButtonRecord2> {

	public FlashButtonRecord2Node(final String name, final ButtonRecord2 buttonRecord) {
		super(name, buttonRecord);

		createChildren();
	}

	private void createChildren() {
		addNode("ButtonReserved", getUserObject().getButtonReserved());
		addNode("ButtonHasBlendMode", getUserObject().getButtonHasBlendMode());
		addNode("ButtonHasFilterList", getUserObject().getButtonHasFilterList());
		addNode("ButtonStateHitTest", getUserObject().getButtonStateHitTest());
		addNode("ButtonStateDown", getUserObject().getButtonStateDown());
		addNode("ButtonStateOver", getUserObject().getButtonStateOver());
		addNode("ButtonStateUp", getUserObject().getButtonStateUp());
		addNode("CharacterID", getUserObject().getCharacterId());
		addNode("PlaceDepth", getUserObject().getPlaceDepth());
		addNode("PlaceMatrix", getUserObject().getPlaceMatrix());
		addNode("ColorTransform", getUserObject().getColorTransform());
		addNode("FilterList", getUserObject().getFilterList());
		addNode("BlendMode", getUserObject().getBlendMode());
	}

	@Override
	public String toString() {
		return String.format("%s : BUTTONRECORD2", getName());
	}
}
