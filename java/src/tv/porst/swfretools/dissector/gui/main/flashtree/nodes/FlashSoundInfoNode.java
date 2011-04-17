package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.SoundInfo;

public class FlashSoundInfoNode extends FlashTreeNode<SoundInfo> {

	public FlashSoundInfoNode(final String name, final SoundInfo soundInfo) {
		super(name, soundInfo);

		createChildren();
	}

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
