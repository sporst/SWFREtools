package tv.porst.swfretools.parser.structures;

public class MultinameLA implements IMultiname {

	private final EncodedU30 nsSet;

	public MultinameLA(final EncodedU30 nsSet) {
		this.nsSet = nsSet;
	}

	@Override
	public int getBitLength() {
		return nsSet.getBitLength();
	}

	@Override
	public int getBitPosition() {
		return nsSet.getBitPosition();
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public EncodedU30 getNsSet() {
		return nsSet;
	}

}
