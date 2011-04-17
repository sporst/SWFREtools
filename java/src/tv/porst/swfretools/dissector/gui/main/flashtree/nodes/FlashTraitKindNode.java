package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.ITraitKind;
import tv.porst.swfretools.parser.structures.TraitClass;
import tv.porst.swfretools.parser.structures.TraitFunction;
import tv.porst.swfretools.parser.structures.TraitMethod;
import tv.porst.swfretools.parser.structures.TraitSlot;

/**
 * Node that represents a TraitKind object in the Flash tree.
 */
public final class FlashTraitKindNode extends FlashTreeNode<ITraitKind> {

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashTraitKindNode(final String name, final ITraitKind value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		if (getUserObject() instanceof TraitClass) {
			final TraitClass cgradient = (TraitClass) getUserObject();
			addNode("slot_id", cgradient.getSlotId());
			addNode("class_index", cgradient.getClassIndex());
		}
		else if (getUserObject() instanceof TraitFunction) {
			final TraitFunction cgradient = (TraitFunction) getUserObject();
			addNode("slot_id", cgradient.getSlotId());
			addNode("function", cgradient.getFunction());
		}
		else if (getUserObject() instanceof TraitMethod) {
			final TraitMethod cgradient = (TraitMethod) getUserObject();
			addNode("disp_id", cgradient.getDispId());
			addNode("method", cgradient.getMethod());
		}
		else if (getUserObject() instanceof TraitSlot) {
			final TraitSlot cgradient = (TraitSlot) getUserObject();
			addNode("SpreadMode", cgradient.getSlotId());
			addNode("InterpolationMode", cgradient.getTypeName());
			addNode("NumGradients", cgradient.getvIndex());
			addNode("GradientRecords", cgradient.getvKind());
		}
		else {
			throw new IllegalStateException("Error: Unknown trait kind type");
		}
	}

	/**
	 * Returns the name for each specific trait class.
	 * 
	 * @return The name for each specific trait class.
	 */
	private String getTraitName() {

		if (getUserObject() instanceof TraitClass) {
			return "Trait_Class";
		}
		else if (getUserObject() instanceof TraitFunction) {
			return "Trait_Flass";
		}
		else if (getUserObject() instanceof TraitMethod) {
			return "Trait_Method";
		}
		else if (getUserObject() instanceof TraitSlot) {
			return "Trait_Slot";
		}
		else {
			throw new IllegalStateException("Error: Unknown trait kind type");
		}
	}

	@Override
	public String toString() {
		return String.format("%s : %s", getName(), getTraitName());
	}
}