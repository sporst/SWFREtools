package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses ARGB structures.
 * 
 * @author sp
 *
 */
public final class ARGBParser {

	/**
	 * Parses an ARGB structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static ARGB parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UINT8 alpha = parseUINT8(parser, 0x00006, fieldName + "::Alpha");
		final UINT8 red = parseUINT8(parser, 0x00006, fieldName + "::Red");
		final UINT8 green = parseUINT8(parser, 0x00006, fieldName + "::Green");
		final UINT8 blue = parseUINT8(parser, 0x00006, fieldName + "::Blue");

		return new ARGB(alpha, red, green, blue);
	}
}