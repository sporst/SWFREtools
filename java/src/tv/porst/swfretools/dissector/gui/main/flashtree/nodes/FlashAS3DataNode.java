package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.AS3Data;

public class FlashAS3DataNode extends FlashTreeNode<AS3Data> {

	public FlashAS3DataNode(final String name, final AS3Data value) {
		super(name, value);

		createChildren();
	}

	private void createChildren() {
		addNode("minor_version", getUserObject().getMinorVersion());
		addNode("major_version", getUserObject().getMajorVersion());
		addNode("constant_pool", getUserObject().getConstantPool());
		addNode("method_count", getUserObject().getMethodCount());
		addNode("method_infos", getUserObject().getMethodInfos());
		addNode("meta_data_count", getUserObject().getMetaDataCount());
		addNode("meta_data", getUserObject().getMetaData());
		addNode("class_count", getUserObject().getClassCount());
		addNode("instances", getUserObject().getInstances());
		addNode("classes", getUserObject().getClasses());
		addNode("script_count", getUserObject().getScriptCount());
		addNode("scripts", getUserObject().getScripts());
		addNode("method_body_count", getUserObject().getMethodBodyCount());
		addNode("method_bodies", getUserObject().getMethodBodies());
	}

	@Override
	public String toString() {
		return String.format("%s : ACTIONSCRIPT3", getName());
	}
}
