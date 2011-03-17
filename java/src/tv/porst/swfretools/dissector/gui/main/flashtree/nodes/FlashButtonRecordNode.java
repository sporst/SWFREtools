package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.ButtonRecord;

public class FlashButtonRecordNode extends FlashTreeNode<ButtonRecord> {

	public FlashButtonRecordNode(final String name, final ButtonRecord buttonRecord) {
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
	}

	@Override
	public String toString() {
		return String.format("%s : BUTTONRECORD", getName());
	}
}
