package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses MorphLineStyle structures.
 * 
 * @author sp
 */
public class MorphLineStyleParser {

	/**
	 * Parses a MorphLineStyle structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName Name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static MorphLineStyle parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UINT16 startWidth = parseUINT16(parser, 0x00006, fieldName + "::StartWidth");
		final UINT16 endWidth = parseUINT16(parser, 0x00006, fieldName + "::EndWidth");
		final RGBA startColor = RGBAParser.parse(parser, fieldName + "::StartColor");
		final RGBA endColor = RGBAParser.parse(parser, fieldName + "::EndColor");

		return new MorphLineStyle(startWidth, endWidth, startColor, endColor);
	}
}