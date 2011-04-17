package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.SoundInfo;

/**
 * Node that represents a FlashSoundInfo object in the Flash tree.
 */
public final class FlashSoundInfoNode extends FlashTreeNode<SoundInfo> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashSoundInfoNode(final String name, final SoundInfo value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		addNode("Reserved", getUserObject().getReserved());
		addNode("SyncStop", getUserObject().getSyncStop());
		addNode("SyncNoMultiple", getUserObject().getSyncNoMultiple());
		addNode("HasEnvelope", getUserObject().getHasEnvelope());
		addNode("HasLoops", getUserObject().getHasLoops());
		addNode("HasOutPoint", getUserObject().getHasOutPoint());
		addNode("HasInPoint", getUserObject().getHasInPoint());
		addNode("InPoint", getUserObject().getInPoint());
		addNode("OutPoint", getUserObject().getOutPoint());
		addNode("LoopCount", getUserObject().getLoopCount());
		addNode("EnvPoints", getUserObject().getEnvPoints());
		addNode("EnvelopeRecords", getUserObject().getEnvelopeRecords());
	}

	@Override
	public String toString() {
		return String.format("%s : SOUNDINFO", getName());
	}
}