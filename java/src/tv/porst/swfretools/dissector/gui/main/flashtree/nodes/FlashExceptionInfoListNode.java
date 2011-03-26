package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeNode;
import tv.porst.swfretools.parser.structures.ExceptionInfo;
import tv.porst.swfretools.parser.structures.ExceptionInfoList;

public class FlashExceptionInfoListNode extends FlashTreeNode<ExceptionInfoList> {

	public FlashExceptionInfoListNode(final String name, final ExceptionInfoList encodedList) {
		super(name, encodedList);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final ExceptionInfo element: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), element);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : exception_info[%d]", getName(), getUserObject().size());
	}
}
