package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseString;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Class for parsing DefineFontName tags.
 */
public final class DefineFontNameParser {

	/**
	 * Parses a DefineFontNames tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static DefineFontNameTag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final UINT16 fontId = parseUINT16(parser, 0x00006, "DefineFontName::FontId");
		final AsciiString fontName = parseString(parser, 0x00006, "DefineFontName::FontName");
		final AsciiString fontCopyright = parseString(parser, 0x00006, "DefineFontName::FontCopyright");

		return new DefineFontNameTag(header, fontId, fontName, fontCopyright);
	}
}