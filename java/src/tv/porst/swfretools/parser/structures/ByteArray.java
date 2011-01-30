package tv.porst.swfretools.parser.structures;

import tv.porst.swfretools.parser.SWFParserHelpers;

/**
 * Represents a parsed byte array.
 * 
 * @author sp
 *
 */
public final class ByteArray {

	/**
	 * Byte position of the byte array in the input stream.
	 */
	private final int bytePosition;

	/**
	 * Byte array value.
	 */
	private final byte[] value;

	/**
	 * Creates a new byte array object.
	 * 
	 * @param bytePosition Byte position of the byte array in the input stream.
	 * @param value Byte array value.
	 */
	public ByteArray(final int bytePosition, final byte[] value) {

		if (bytePosition < 0) {
			throw new IllegalArgumentException("Byte position must not be negative");
		}

		SWFParserHelpers.checkNull(value, "Value");

		this.bytePosition = bytePosition;
		this.value = value.clone();
	}

	/**
	 * Returns the byte position of the byte array in the input stream.
	 *
	 * @return The byte position of the byte array in the input stream.
	 */
	public int getBytePosition() {
		return bytePosition;
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