package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseString;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Class for parsing EnableDebugger2 tags.
 * 
 * @author sp
 */
public final class EnableDebugger2Parser {

	/**
	 * Parses an EnableDebugger2 tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static EnableDebugger2Tag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final UINT16 reserved = parseUINT16(parser, 0x00006, "EnableDebugger2::Reserved");
		final AsciiString password = parseString(parser, 0x00006, "EnableDebugger2::Reserved");

		return new EnableDebugger2Tag(header, reserved, password);
	}

}
