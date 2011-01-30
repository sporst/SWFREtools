package tv.porst.swfretools.parser;

/**
 * Describes an error condition that can happen during SWF parsing.
 */
public final class ParserError {

	/**
	 * Creates a new parser error object.
	 * 
	 * @param offset The offset where the parser error happened.
	 * @param description Description of the erroneous situation.
	 */
	public ParserError(final int offset, final String description) {

		if (offset < 0) {
			throw new IllegalArgumentException("Offset argument must not be negative");
		}

		if (description == null) {
			throw new IllegalStateException("Error description must not be null");
		}
	}
}