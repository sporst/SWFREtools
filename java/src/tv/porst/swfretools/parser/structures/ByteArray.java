package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.swfretools.parser.SWFParserHelpers;

/**
 * Represents a parsed byte array.
 * 
 * @author sp
 *
 */
public final class ByteArray implements IFileElement {

	/**
	 * Bit position of the byte array in the input stream.
	 */
	private final int bitPosition;

	/**
	 * Byte array value.
	 */
	private final byte[] value;

	/**
	 * Creates a new byte array object.
	 * 
	 * @param bitPosition Bit position of the byte array in the input stream.
	 * @param value Byte array value.
	 */
	public ByteArray(final int bitPosition, final byte[] value) {

		if (bitPosition < 0) {
			throw new IllegalArgumentException("Bit position must not be negative");
		}

		SWFParserHelpers.checkNull(value, "Value");

		this.bitPosition = bitPosition;
		this.value = value.clone();
	}

	@Override
	public int getBitLength() {
		return value.length * 8;
	}

	@Override
	public int getBitPosition() {
		return bitPosition;
	}

	/**
	 * Returns the byte position of the byte array in the input stream.
	 *
	 * @return The byte position of the byte array in the input stream.
	 */
	public int getBytePosition() {
		return bitPosition;
	}

	/**
	 * Returns the byte array value.
	 *
	 * @return The byte array value.
	 */
	public byte[] getValue() {
		return value.clone();
	}
}