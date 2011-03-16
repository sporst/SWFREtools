package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.ClipEventFlags;

public class FlashClipEventFlagsNode extends FlashTreeNode<ClipEventFlags> {

	public FlashClipEventFlagsNode(final String name, final ClipEventFlags clipEventFlags) {
		super(name, clipEventFlags);

		createChildren();
	}

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
