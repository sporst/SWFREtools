package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.SoundEnvelope;
import tv.porst.swfretools.parser.structures.SoundEnvelopeList;

public class FlashSoundEnvelopeListNode extends FlashTreeNode<SoundEnvelopeList> {

	public FlashSoundEnvelopeListNode(final String name, final SoundEnvelopeList soundEnvelopeList) {
		super(name, soundEnvelopeList);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final SoundEnvelope soundEnvelope: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), soundEnvelope);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : SOUNDENVELOPELIST", getName());
	}
}