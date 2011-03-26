package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.ExceptionInfo;

public class FlashExceptionInfoNode extends FlashTreeNode<ExceptionInfo> {

	public FlashExceptionInfoNode(final String name, final ExceptionInfo exceptionInfo) {
		super(name, exceptionInfo);

		createChildren();
	}

	private void createChildren() {
		addNode("from", getUserObject().getFrom());
		addNode("to", getUserObject().getTo());
		addNode("target", getUserObject().getTarget());
		addNode("exc_type", getUserObject().getExcType());
		addNode("var_name", getUserObject().getVarName());
	}

	@Override
	public String toString() {
		return String.format("%s : exception_info", getName());
	}
}
