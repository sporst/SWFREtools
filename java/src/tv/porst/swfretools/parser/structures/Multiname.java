package tv.porst.swfretools.parser.structures;

import tv.porst.swfretools.parser.SWFParserHelpers;

public class Multiname implements IMultiname {

	private final EncodedU30 name;

	private final EncodedU30 nsSet;

	public Multiname(final EncodedU30 name, final EncodedU30 nsSet) {
		this.name = name;
		this.nsSet = nsSet;
	}
	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(name, nsSet);
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

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public EncodedU30 getNsSet() {
		return nsSet;
	}

}
