package tv.porst.swfretools.parser.structures;

/**
 * Represents an encoded unsigned 32 bit integer value.
 * 
 * @author sp
 *
 */
public final class EncodedU32 {

	/**
	 * The decoded integer value.
	 */
	private final long value;

	/**
	 * Creates a new encoded integer value.
	 * 
	 * @param value The decoded integer value.
	 */
	public EncodedU32(final long value) {

		this.value = value;
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