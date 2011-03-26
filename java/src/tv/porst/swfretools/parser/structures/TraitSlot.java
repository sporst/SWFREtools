package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;

public class TraitSlot implements ITraitKind {

	private final EncodedU30 slotId;

	private final EncodedU30 typeName;

	private final EncodedU30 vIndex;

	private final UINT8 vKind;

	public TraitSlot(final EncodedU30 slotId, final EncodedU30 typeName, final EncodedU30 vIndex,
			final UINT8 vKind) {

		this.slotId = slotId;
		this.typeName = typeName;
		this.vIndex = vIndex;
		this.vKind = vKind;
	}
	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(slotId, typeName, vIndex, vKind);
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
	public EncodedU30 getSlotId() {
		return slotId;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public EncodedU30 getTypeName() {
		return typeName;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public EncodedU30 getvIndex() {
		return vIndex;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public UINT8 getvKind() {
		return vKind;
	}

}
