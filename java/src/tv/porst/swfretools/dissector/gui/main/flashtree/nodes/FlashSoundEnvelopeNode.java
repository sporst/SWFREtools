package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.SoundEnvelope;

public class FlashSoundEnvelopeNode extends FlashTreeNode<SoundEnvelope> {

	public FlashSoundEnvelopeNode(final String name, final SoundEnvelope soundEnvelope) {
		super(name, soundEnvelope);

		createChildren();
	}

	private void createChildren() {
		addNode("Pos44", getUserObject().getPos44());
		addNode("LeftLevel", getUserObject().getLeftLevel());
		addNode("RightLevel", getUserObject().getRightLevel());
	}

	@Override
	public String toString() {
		return String.format("%s : SOUNDENVELOPE", getName());
	}
}
