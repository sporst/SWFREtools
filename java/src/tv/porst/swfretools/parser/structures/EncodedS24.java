package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.IFileElement;

/**
 * Represents an encoded signed 24 bit integer value.
 * 
 * @author sp
 *
 */
public final class EncodedS24 implements IFileElement {

	private final int bitPosition;

	private final int bitLength;

	/**
	 * The decoded integer value.
	 */
	private final long value;

	/**
	 * Creates a new encoded integer value.
	 * 
	 * @param value The decoded integer value.
	 */
	public EncodedS24(final int bitPosition, final int bitLength, final long value) {

		this.bitPosition = bitPosition;
		this.bitLength = bitLength;
		this.value = value;
	}

	@Override
	public int getBitLength() {
		return bitLength;
	}

	@Override
	public int getBitPosition() {
		return bitPosition;
	}

	/**
	 * Returns the decoded integer value.
	 * 
	 * @return The decoded integer value.
	 */
	public long value() {
		return value;
	}
}