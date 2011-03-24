package tv.porst.swfretools.dissector.gui.main.flashtree;

import tv.porst.swfretools.dissector.gui.main.hexview.FlashHexView;


public class FlashTreeNodeSelectionHandler {

	public static void handleSelection(final FlashTreeNode node, final FlashHexView hexView) {

		hexView.setFile(FlashTreeHelpers.getLoadedFile(node));

		hexView.getHexView().setCurrentOffset(node.getUserObject().getBitPosition() / 8);
		hexView.getHexView().setSelectionLength(2 * ((node.getUserObject().getBitLength() + 7) / 8));
	}

}
