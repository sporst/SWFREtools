package tv.porst.swfretools.parser.structures;

public class RTQNameA implements IMultiname {

	private final EncodedU30 name;

	public RTQNameA(final EncodedU30 name) {
		this.name = name;
	}

	@Override
	public int getBitLength() {
		return name.getBitLength();
	}

	@Override
	public int getBitPosition() {
		return name.getBitPosition();
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public EncodedU30 getName() {
		return name;
	}

}
