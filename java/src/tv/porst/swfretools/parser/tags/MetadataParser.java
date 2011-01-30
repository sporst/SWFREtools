package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseString;
import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Class for parsing Metadata tags.
 * 
 * @author sp
 */
public final class MetadataParser {

	/**
	 * Parses a Metadata tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static MetadataTag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final AsciiString metadata = parseString(parser, 0x00006, "Metadata::Metadata");

		return new MetadataTag(header, metadata);
	}
}