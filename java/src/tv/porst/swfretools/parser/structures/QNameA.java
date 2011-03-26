package tv.porst.swfretools.parser.structures;

import tv.porst.swfretools.parser.SWFParserHelpers;

public class QNameA implements IMultiname {

	private final EncodedU30 ns;
	private final EncodedU30 name;

	public QNameA(final EncodedU30 ns, final EncodedU30 name) {
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

}
