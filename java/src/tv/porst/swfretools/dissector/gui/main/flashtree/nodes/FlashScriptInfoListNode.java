package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ScriptInfo;
import tv.porst.swfretools.parser.structures.ScriptInfoList;

public class FlashScriptInfoListNode extends FlashTreeNode<ScriptInfoList> {

	public FlashScriptInfoListNode(final String name, final ScriptInfoList encodedList) {
		super(name, encodedList);

		createChildren();
	}

	private void createChildren() {

		int counter = 0;

		for (final ScriptInfo element: getUserObject()) {

			addNode(String.format("%s[%d]", getName(), counter), element);

			counter++;
		}
	}

	@Override
	public String toString() {
		return String.format("%s : script_info[%d]", getName(), getUserObject().size());
	}
}
