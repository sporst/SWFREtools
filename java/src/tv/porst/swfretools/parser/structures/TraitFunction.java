package tv.porst.swfretools.parser.structures;

import tv.porst.swfretools.parser.SWFParserHelpers;

public class TraitFunction implements ITraitKind {

	private final EncodedU30 slotId;

	private final EncodedU30 function;

	public TraitFunction(final EncodedU30 slotId, final EncodedU30 function) {
		this.slotId = slotId;
		this.function = function;
	}
	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(slotId, function);
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
	public EncodedU30 getFunction() {
		return function;
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
