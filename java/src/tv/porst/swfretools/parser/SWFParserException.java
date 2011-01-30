package tv.porst.swfretools.parser;

/**
 * Exception class that is used to signal problems with the parsing process.
 */
public final class SWFParserException extends Exception {

	/**
	 * The exception code.
	 */
	private final int exceptionCode;

	/**
	 * The offset where the exception happened.
	 */
	private final int offset;

	/**
	 * Creates a new parser exception.
	 * 
	 * @param exceptionCode The exception code.
	 * @param message Describes the parser exception.
	 * @param offset The offset where the exception happened.
	 */
	public SWFParserException(final int exceptionCode, final int offset, final String message) {
		super(message);

		if (message == null) {
			throw new IllegalArgumentException("Exception message must not be null");
		}

		if (offset < 0) {
			throw new IllegalArgumentException("Offset argument must not be negative");
		}

		this.exceptionCode = exceptionCode;
		this.offset = offset;
	}

	/**
	 * Returns the exception code.
	 *
	 * @return The exception code.
	 */
	public int getExceptionCode() {
		return exceptionCode;
	}

	/**
	 * Returns the offset where the exception happened.
	 * 
	 * @return The offset where the exception happened.
	 */
	public int getOffset() {
		return offset;
	}
}