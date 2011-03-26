package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.AsciiString;

public class StringInfo {

	private final EncodedU30 size;
	private final AsciiString name;

	public StringInfo(final EncodedU30 size, final AsciiString name) {
		this.size = size;
		this.name = name;
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
