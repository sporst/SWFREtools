package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses Pix24 structures.
 * 
 * @author sp
 */
public final class Pix24Parser {

	/**
	 * Parses a Pix24 structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName Name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static Pix24 parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UINT8 pix24Reserved = parseUINT8(parser, 0x00006, fieldName + "::Pix24Reserved");
		final UINT8 pix24Red = parseUINT8(parser, 0x00006, fieldName + "::Pix24Red");
		final UINT8 pix24Green = parseUINT8(parser, 0x00006, fieldName + "::Pix24Green");
		final UINT8 pix24Blue = parseUINT8(parser, 0x00006, fieldName + "::Pix24Blue");

		return new Pix24(pix24Reserved, pix24Red, pix24Green, pix24Blue);
	}
}