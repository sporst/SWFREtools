package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.AS3Code;

/**
 * Node that represents a ActionScript code node object in the Flash tree.
 */
public final class FlashAS3CodeNode extends FlashTreeNode<AS3Code> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashAS3CodeNode(final String name, final AS3Code value) {
		super(name, value);
	}

	@Override
	public String toString() {
		return String.format("%s : code", getName());
	}
}