package tv.porst.swfretools.parser.structures;

import tv.porst.swfretools.parser.SWFParserHelpers;

public class QName implements IMultiname {

	private final EncodedU30 ns;

	private final EncodedU30 name;

	public QName(final EncodedU30 ns, final EncodedU30 name) {
		this.ns = ns;
		this.name = name;
	}
	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(ns, name);
	}

	@Override
	public int getBitPosition() {
		return ns.getBitPosition();
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
	public EncodedU30 getNs() {
		return ns;
	}

}
