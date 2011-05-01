package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.panels.IExtraPanel;
import tv.porst.swfretools.parser.structures.IMultiname;
import tv.porst.swfretools.parser.structures.Multiname;
import tv.porst.swfretools.parser.structures.MultinameA;
import tv.porst.swfretools.parser.structures.MultinameL;
import tv.porst.swfretools.parser.structures.MultinameLA;
import tv.porst.swfretools.parser.structures.QName;
import tv.porst.swfretools.parser.structures.QNameA;
import tv.porst.swfretools.parser.structures.RTQName;
import tv.porst.swfretools.parser.structures.RTQNameA;
import tv.porst.swfretools.parser.structures.RTQNameL;
import tv.porst.swfretools.parser.structures.RTQNameLA;

/**
 * Node that represents a Multiname object in the Flash tree.
 */
public final class FlashMultinameNode extends FlashTreeNode<IMultiname> {

	private IExtraPanel panel;

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashMultinameNode(final String name, final IMultiname value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		if (getUserObject() instanceof Multiname) {
			final Multiname cname = (Multiname) getUserObject();
			addNode("name", cname.getName());
			addNode("ns_set", cname.getNsSet());
		}
		else if (getUserObject() instanceof MultinameA) {
			final MultinameA cname = (MultinameA) getUserObject();
			addNode("name", cname.getName());
			addNode("ns_set", cname.getNsSet());
		}
		else if (getUserObject() instanceof MultinameL) {
			final MultinameL cname = (MultinameL) getUserObject();
			addNode("ns_set", cname.getNsSet());
		}
		else if (getUserObject() instanceof MultinameLA) {
			final MultinameLA cname = (MultinameLA) getUserObject();
			addNode("ns_set", cname.getNsSet());
		}
		else if (getUserObject() instanceof QName) {
			final QName cname = (QName) getUserObject();
			addNode("ns", cname.getNs());
			addNode("name", cname.getName());
		}
		else if (getUserObject() instanceof QNameA) {
			final QNameA cname = (QNameA) getUserObject();
			addNode("ns", cname.getNs());
			addNode("name", cname.getName());
		}
		else if (getUserObject() instanceof RTQName) {
			final RTQName cname = (RTQName) getUserObject();
			addNode("name", cname.getName());
		}
		else if (getUserObject() instanceof RTQNameA) {
			final RTQNameA cname = (RTQNameA) getUserObject();
			addNode("name", cname.getName());
		}
		else if (getUserObject() instanceof RTQNameL) {
			// Nothing to do
		}
		else if (getUserObject() instanceof RTQNameLA) {
			// Nothing to do
		}
		else {
			throw new IllegalStateException("Error: Unknown multiname");
		}
	}

	/**
	 * Returns the correct name for the multiname represented by this
	 * node.
	 * 
	 * @return The name for the multiname object.
	 */
	private String getGradientName() {

		if (getUserObject() instanceof Multiname) {
			return "Multiname";
		}
		else if (getUserObject() instanceof MultinameA) {
			return "MultinameA";
		}
		else if (getUserObject() instanceof MultinameL) {
			return "MultinameL";
		}
		else if (getUserObject() instanceof MultinameLA) {
			return "MultinameLA";
		}
		else if (getUserObject() instanceof QName) {
			return "QName";
		}
		else if (getUserObject() instanceof QNameA) {
			return "QNameA";
		}
		else if (getUserObject() instanceof RTQName) {
			return "RTQName";
		}
		else if (getUserObject() instanceof RTQNameA) {
			return "RTQNameA";
		}
		else if (getUserObject() instanceof RTQNameL) {
			return "RTQNameL";
		}
		else if (getUserObject() instanceof RTQNameLA) {
			return "RTQNameLA";
		}
		else {
			throw new IllegalStateException("Error: Unknown multiname");
		}
	}

	@Override
	public String toString() {
		return String.format("%s : %s", getName(), getGradientName());
	}
}
