package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses GradRecord3 structures.
 * 
 * @author sp
 */
public final class GradRecord3Parser {

	/**
	 * Parses a GradRecord3 structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName Name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static GradRecord3 parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UINT8 ratio = parseUINT8(parser, 0x00006, fieldName + "::Ratio");
		final RGBA color = RGBAParser.parse(parser, fieldName + "::Color");

		return new GradRecord3(ratio, color);
	}
}