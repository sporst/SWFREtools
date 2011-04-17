package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.SoundEnvelope;
import tv.porst.swfretools.parser.structures.SoundEnvelopeList;

/**
 * Node that represents a SoundEnvelopeList object in the Flash tree.
 */
public final class FlashSoundEnvelopeListNode extends FlashTreeNode<SoundEnvelopeList> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashSoundEnvelopeListNode(final String name, final SoundEnvelopeList value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
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