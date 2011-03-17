package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.IFileElement;

/**
 * Represents an encoded unsigned 32 bit integer value.
 * 
 * @author sp
 *
 */
public final class EncodedU32 implements IFileElement {

	/**
	 * The decoded integer value.
	 */
	private final long value;

	private final int bitPosition;

	private final int bitLength;

	/**
	 * Creates a new encoded integer value.
	 * 
	 * @param value The decoded integer value.
	 */
	public EncodedU32(final int bitPosition, final int bitLength, final long value) {

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