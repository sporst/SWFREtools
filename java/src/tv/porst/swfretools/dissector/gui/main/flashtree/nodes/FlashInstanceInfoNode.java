package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.InstanceInfo;

public class FlashInstanceInfoNode extends FlashTreeNode<InstanceInfo> {

	public FlashInstanceInfoNode(final String name, final InstanceInfo instanceInfo) {
		super(name, instanceInfo);

		createChildren();
	}

	private void createChildren() {
		addNode("name", getUserObject().getName());
		addNode("super_name", getUserObject().getSuperName());
		addNode("flags", getUserObject().getFlags());
		addNode("protected_ns", getUserObject().getProtectedNs());
		addNode("interface_count", getUserObject().getInterfaceCount());
		addNode("interfaces", getUserObject().getInterfaces());
		addNode("iinit", getUserObject().getIinit());
		addNode("trait_count", getUserObject().getTraitCount());
		addNode("traits", getUserObject().getTraits());
	}

	@Override
	public String toString() {
		return String.format("%s : instance_info", getName());
	}
}
