package tv.porst.swfretools.dissector.gui.main.flashtree;

import tv.porst.swfretools.dissector.gui.main.DetailPanel;
import tv.porst.swfretools.dissector.gui.main.flashtree.nodes.FlashAS3CodeNode;
import tv.porst.swfretools.dissector.gui.main.flashtree.nodes.FlashTagNode;
import tv.porst.swfretools.dissector.gui.main.hexview.FlashHexView;
import tv.porst.swfretools.parser.tags.DoABCTag;
import tv.porst.swfretools.parser.tags.DoActionTag;
import tv.porst.swfretools.parser.tags.DoInitActionTag;


public class FlashTreeNodeSelectionHandler {

	public static void handleSelection(final FlashTreeNode node, final DetailPanel detailPanel) {

		detailPanel.clear();

		final FlashHexView hexView = detailPanel.getHexView();

		hexView.setFile(FlashTreeHelpers.getLoadedFile(node));

		hexView.getHexView().setCurrentOffset(node.getUserObject().getBitPosition() / 8);
		hexView.getHexView().setSelectionLength(2 * ((node.getUserObject().getBitLength() + 7) / 8));

		if (node instanceof FlashAS3CodeNode) {
			detailPanel.addPanel("Code", ((FlashAS3CodeNode) node).getExtraPanel());
		}
		else if (node.getUserObject() instanceof DoABCTag) {
			detailPanel.addPanel("Code", ((FlashTagNode) node).getExtraPanel());
		}
		else if (node.getUserObject() instanceof DoActionTag) {
			detailPanel.addPanel("Code", ((FlashTagNode) node).getExtraPanel());
		}
		else if (node.getUserObject() instanceof DoInitActionTag) {
			detailPanel.addPanel("Code", ((FlashTagNode) node).getExtraPanel());
		}
	}

}
