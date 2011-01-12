package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseByteArray;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.ByteArray;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Class for parsing JPEGTables tags.
 * 
 * @author sp
 */
public final class JPEGTablesParser {

	/**
	 * Parses a JPEGTables tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static JPEGTablesTag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {
		final ByteArray jpegData = parseByteArray(parser, header.getNormalizedLength(), 0x00006, "JPEGTables::JPEGData");

		return new JPEGTablesTag(header, jpegData);
	}

}
