package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.ParamInfo;

public class FlashParamInfoNode extends FlashTreeNode<ParamInfo> {

	public FlashParamInfoNode(final String name, final ParamInfo paramInfo) {
		super(name, paramInfo);

		createChildren();
	}

	private void createChildren() {
		addNode("param_names", getUserObject().getParamNames());
	}

	@Override
	public String toString() {
		return String.format("%s : param_info", getName());
	}
}
