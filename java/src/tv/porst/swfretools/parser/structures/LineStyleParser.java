package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses LineStyle structures.
 * 
 * @author sp
 */
public final class LineStyleParser {

	/**
	 * Parses a LineStyle structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName Name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static LineStyle parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UINT16 lineStyleType = parseUINT16(parser, 0x00006, fieldName + "::LineStyleType");
		final RGB color = RGBParser.parse(parser, fieldName + "::Color");

		return new LineStyle(lineStyleType, color);
	}
}