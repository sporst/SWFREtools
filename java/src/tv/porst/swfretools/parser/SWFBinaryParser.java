package tv.porst.swfretools.parser;

import tv.porst.splib.binaryparser.BinaryParser;

/**
 * Binary parser for parsing Flash files.
 * 
 * @author sp
 *
 */
public final class SWFBinaryParser extends BinaryParser {

	/**
	 * Creates a new SWF binary parser object.
	 * 
	 * @param data The byte input to parse.
	 */
	public SWFBinaryParser(final byte[] data) {
		super(data);
	}
}