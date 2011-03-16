package tv.porst.swfretools.dissector.gui.main.flashtree;

import tv.porst.swfretools.dissector.gui.main.flashtree.nodes.FlashFileNode;
import tv.porst.swfretools.dissector.gui.main.flashtree.nodes.FlashRGBNode;
import tv.porst.swfretools.dissector.gui.main.flashtree.nodes.FlashTagNode;
import tv.porst.swfretools.dissector.gui.main.flashtree.nodes.FlashUINT16ListNode;
import tv.porst.swfretools.dissector.gui.main.flashtree.nodes.FlashUINT16Node;
import tv.porst.swfretools.dissector.gui.main.flashtree.nodes.FlashUINT8Node;
import tv.porst.swfretools.dissector.gui.main.hexview.FlashHexView;
import tv.porst.swfretools.parser.structures.RGB;
import tv.porst.swfretools.parser.tags.Tag;


public class FlashTreeNodeSelectionHandler {

	private static void handleNodeSelection(final FlashFileNode node, final FlashHexView hexView) {
		hexView.getHexView().setCurrentOffset(0);
		hexView.getHexView().setSelectionLength(0);
	}

	private static void handleNodeSelection(final FlashRGBNode node, final FlashHexView hexView) {
		final RGB rgb = node.getUserObject();

		hexView.getHexView().setCurrentOffset(rgb.getRed().getBytePosition());
		hexView.getHexView().setSelectionLength(6);
	}

	private static void handleNodeSelection(final FlashTagNode node, final FlashHexView hexView) {
		final Tag tag = node.getUserObject();

		hexView.getHexView().setCurrentOffset(tag.getHeader().getPosition());
		hexView.getHexView().setSelectionLength(2 * (tag.getHeader().getNormalizedLength() + tag.getHeader().getHeaderLength()));
	}

	private static void handleNodeSelection(final FlashUINT16ListNode node, final FlashHexView hexView) {

		if (node.getUserObject().size() == 0) {
			hexView.getHexView().setSelectionLength(0);
		}
		else {
			hexView.getHexView().setCurrentOffset(node.getUserObject().getBytePosition());
			hexView.getHexView().setSelectionLength(4 * node.getUserObject().size());
		}
	}

	private static void handleNodeSelection(final FlashUINT16Node node, final FlashHexView hexView) {
		hexView.getHexView().setCurrentOffset(node.getUserObject().getBytePosition());
		hexView.getHexView().setSelectionLength(4);
	}

	private static void handleNodeSelection(final FlashUINT8Node node, final FlashHexView hexView) {
		hexView.getHexView().setCurrentOffset(node.getUserObject().getBytePosition());
		hexView.getHexView().setSelectionLength(2);
	}

	public static void handleSelection(final FlashTreeNode node, final FlashHexView hexView) {

		hexView.setFile(FlashTreeHelpers.getLoadedFile(node));

		if (node instanceof FlashFileNode) {
			handleNodeSelection((FlashFileNode) node, hexView);
		}
		else if (node instanceof FlashTagNode) {
			handleNodeSelection((FlashTagNode) node, hexView);
		}
		else if (node instanceof FlashRGBNode) {
			handleNodeSelection((FlashRGBNode) node, hexView);
		}
		else if (node instanceof FlashUINT8Node) {
			handleNodeSelection((FlashUINT8Node) node, hexView);
		}
		else if (node instanceof FlashUINT16Node) {
			handleNodeSelection((FlashUINT16Node) node, hexView);
		}
		else if (node instanceof FlashUINT16ListNode) {
			handleNodeSelection((FlashUINT16ListNode) node, hexView);
		}
		else {
			throw new IllegalStateException("Unknown node " + node);
		}
	}

}
