package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses LineStyle3 structures.
 * 
 * @author sp
 */
public final class LineStyle3Parser {

	/**
	 * Parses a LineStyle3 structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName Name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static LineStyle3 parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UINT8 width = parseUINT8(parser, 0x00006, fieldName + "::Width");
		final RGBA color = RGBAParser.parse(parser, fieldName + "::Color");

		return new LineStyle3(width, color);

	}
}