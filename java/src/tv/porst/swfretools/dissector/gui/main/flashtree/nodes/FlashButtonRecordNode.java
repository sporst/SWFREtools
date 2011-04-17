package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ButtonRecord;

/**
 * Node that represents a ButtonRecord object in the Flash tree.
 */
public final class FlashButtonRecordNode extends FlashTreeNode<ButtonRecord> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashButtonRecordNode(final String name, final ButtonRecord value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
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