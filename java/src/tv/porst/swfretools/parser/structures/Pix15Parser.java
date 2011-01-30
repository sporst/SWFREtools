package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUBits;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses Pix15 structures.
 * 
 * @author sp
 */
public final class Pix15Parser {

	/**
	 * Parses a Pix15 structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName Name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static Pix15 parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UBits pix15Reserved = parseUBits(parser, 1, 0x00006, fieldName + "::Pix15Reserved");
		final UBits pix15Red = parseUBits(parser, 5, 0x00006, fieldName + "::Pix15Red");
		final UBits pix15Green = parseUBits(parser, 5, 0x00006, fieldName + "::Pix15Green");
		final UBits pix15Blue = parseUBits(parser, 5, 0x00006, fieldName + "::Pix15Blue");

		return new Pix15(pix15Reserved, pix15Red, pix15Blue, pix15Green);
	}
}