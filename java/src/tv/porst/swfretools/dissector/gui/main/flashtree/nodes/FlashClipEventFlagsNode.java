package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ClipEventFlags;

/**
 * Node that represents a ClipEventFlags object in the Flash tree.
 */
public final class FlashClipEventFlagsNode extends FlashTreeNode<ClipEventFlags> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashClipEventFlagsNode(final String name, final ClipEventFlags value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("ClipEventKeyUp", getUserObject().getClipEventKeyUp());
		addNode("ClipEventKeyDown", getUserObject().getClipEventKeyDown());
		addNode("ClipEventMouseUp", getUserObject().getClipEventMouseUp());
		addNode("ClipEventMouseDown", getUserObject().getClipEventMouseDown());
		addNode("ClipEventMouseMove", getUserObject().getClipEventMouseMove());
		addNode("ClipEventUnload", getUserObject().getClipEventUnload());
		addNode("ClipEventEnterFrame", getUserObject().getClipEventEnterFrame());
		addNode("ClipEventEventLoad", getUserObject().getClipEventLoad());
		addNode("ClipEventDragOver", getUserObject().getClipEventDragOver());
		addNode("ClipEventRollOut", getUserObject().getClipEventRollOut());
		addNode("ClipEventRollOver", getUserObject().getClipEventRollOver());
		addNode("ClipEventReleaseOutside", getUserObject().getClipEventReleaseOutside());
		addNode("ClipEventRelease", getUserObject().getClipEventRelease());
		addNode("ClipEventPress", getUserObject().getClipEventPress());
		addNode("ClipEventInitialize", getUserObject().getClipEventInitialize());
		addNode("ClipEventData", getUserObject().getClipEventData());
		addNode("Reserved", getUserObject().getReserved());
		addNode("ClipEventConstruct", getUserObject().getClipEventConstruct());
		addNode("ClipEventKeyPress", getUserObject().getClipEventKeyPress());
		addNode("ClipEventDragOut", getUserObject().getClipEventDragOut());
		addNode("Reserved2", getUserObject().getReserved2());
	}

	@Override
	public String toString() {
		return String.format("%s : CLIPEVENTFLAGS", getName());
	}
}