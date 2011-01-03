package tv.porst.swfretools.parser;

/**
 * Exception class that is used to signal problems with the parsing process.
 */
public final class SWFParserException extends Exception {

	/**
	 * Creates a new parser exception.
	 * 
	 * @param message Describes the parser exception.
	 */
	public SWFParserException(final String message) {
		super(message);

		if (message == null) {
			throw new IllegalArgumentException("Exception message must not be null");
		}
	}

}
