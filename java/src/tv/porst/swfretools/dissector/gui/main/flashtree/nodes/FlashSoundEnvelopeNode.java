package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.SoundEnvelope;

/**
 * Node that represents a SoundEnvelope object in the Flash tree.
 */
public final class FlashSoundEnvelopeNode extends FlashTreeNode<SoundEnvelope> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashSoundEnvelopeNode(final String name, final SoundEnvelope value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
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