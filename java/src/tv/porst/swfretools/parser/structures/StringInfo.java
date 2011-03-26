package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.swfretools.parser.SWFParserHelpers;

public class StringInfo implements IFileElement {

	private final EncodedU30 size;
	private final AsciiString name;

	public StringInfo(final EncodedU30 size, final AsciiString name) {
		this.size = size;
		this.name = name;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(size, name);
	}

	@Override
	public int getBitPosition() {
		return size.getBitPosition();
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public AsciiString getName() {
		return name;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public EncodedU30 getSize() {
		return size;
	}



}
