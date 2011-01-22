package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseBits;
import tv.porst.splib.io.Bits;
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

		final Bits pix15Reserved = parseBits(parser, 1, 0x00006, fieldName + "::Pix15Reserved");
		final Bits pix15Red = parseBits(parser, 5, 0x00006, fieldName + "::Pix15Red");
		final Bits pix15Green = parseBits(parser, 5, 0x00006, fieldName + "::Pix15Green");
		final Bits pix15Blue = parseBits(parser, 5, 0x00006, fieldName + "::Pix15Blue");

		return new Pix15(pix15Reserved, pix15Red, pix15Blue, pix15Green);
	}
}