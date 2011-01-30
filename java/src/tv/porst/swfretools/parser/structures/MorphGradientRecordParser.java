package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses MorphGradientRecord structures.
 * 
 * @author sp
 */
public final class MorphGradientRecordParser {

	/**
	 * Parses a MorphGradientRecord structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName Name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static MorphGradientRecord parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UINT8 startRatio = parseUINT8(parser, 0x00006, fieldName + "::StartRatio");
		final RGBA startColor = RGBAParser.parse(parser, fieldName + "::StartColor");
		final UINT8 endRatio = parseUINT8(parser, 0x00006, fieldName + "::EndRatio");
		final RGBA endColor = RGBAParser.parse(parser, fieldName + "::EndColor");

		return new MorphGradientRecord(startRatio, startColor, endRatio, endColor);
	}
}