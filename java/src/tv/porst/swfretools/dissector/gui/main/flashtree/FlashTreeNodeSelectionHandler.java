package tv.porst.swfretools.dissector.gui.main.flashtree;

import tv.porst.swfretools.dissector.gui.main.DetailPanel;
import tv.porst.swfretools.dissector.gui.main.flashtree.nodes.FlashAS3CodeNode;
import tv.porst.swfretools.dissector.gui.main.flashtree.nodes.FlashTagNode;
import tv.porst.swfretools.dissector.gui.main.flashtree.nodes.FlashTreeNode;
import tv.porst.swfretools.dissector.gui.main.hexview.FlashHexView;
import tv.porst.swfretools.parser.tags.DoABCTag;
import tv.porst.swfretools.parser.tags.DoActionTag;
import tv.porst.swfretools.parser.tags.DoInitActionTag;

/**
 * Class that handles clicks on tree nodes.
 */
public final class FlashTreeNodeSelectionHandler {

	/**
	 * Handles selection on Flash tree nodes.
	 * 
	 * @param node The node that was selected.
	 * @param detailPanel The detail panel that is shown on the right side of the window.
	 */
	public static void handleSelection(final FlashTreeNode<?> node, final DetailPanel detailPanel) {

		if (node == null) {
			throw new IllegalArgumentException("Node argument must not be null");
		}

		if (detailPanel == null) {
			throw new IllegalArgumentException("DetailPanel argument must not be null.");
		}

		detailPanel.removeAllOptionalPanels();

		// Step I: Highlight the selected element in the hex view
		final FlashHexView hexView = detailPanel.getHexView();

		hexView.setFile(FlashTreeHelpers.getLoadedFile(node));

		hexView.getHexView().setCurrentOffset(node.getUserObject().getBitPosition() / 8);
		hexView.getHexView().setSelectionLength(2 * ((node.getUserObject().getBitLength() + 7) / 8));

		// Step II: Display additional panels where necessary.
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