package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses GradRecord structures.
 * 
 * @author sp
 */
public final class GradRecordParser {

	/**
	 * Parses a GradRecord structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName Name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static GradRecord parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UINT8 ratio = parseUINT8(parser, 0x00006, fieldName + "::Ratio");
		final RGB color = RGBParser.parse(parser, fieldName + "::RGB");

		return new GradRecord(ratio, color);
	}
}