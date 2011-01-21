package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseBits;
import tv.porst.splib.io.Bits;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses a Shape3 structure.
 * 
 * @author sp
 *
 */
public final class Shape3Parser {

	/**
	 * Parses a Shape3Record structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static Shape3 parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final Bits numFillBits = parseBits(parser, 4, 0x00006, fieldName + "::NumFillBits");
		final Bits numLineBits = parseBits(parser, 4, 0x00006, fieldName + "::NumLineBits");
		final Shape3Record shapeRecord = ShapeRecord3Parser.parse(parser, numFillBits, numLineBits, fieldName + "::ShapeRecord");

		return new Shape3(numFillBits, numLineBits, shapeRecord);
	}
}