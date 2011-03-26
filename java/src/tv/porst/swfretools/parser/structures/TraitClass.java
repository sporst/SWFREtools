package tv.porst.swfretools.parser.structures;

import tv.porst.swfretools.parser.SWFParserHelpers;

public class TraitClass implements ITraitKind {

	private final EncodedU30 slotId;

	private final EncodedU30 classIndex;

	public TraitClass(final EncodedU30 slotId, final EncodedU30 classIndex) {
		this.slotId = slotId;
		this.classIndex = classIndex;
	}
	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(slotId, classIndex);
	}

	@Override
	public int getBitPosition() {
		return slotId.getBitPosition();
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public EncodedU30 getClassIndex() {
		return classIndex;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public EncodedU30 getSlotId() {
		return slotId;
	}

}
