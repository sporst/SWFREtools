package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses FIXED structures.
 * 
 * @author sp
 *
 */
public final class FixedParser {

	/**
	 * Parses a FIXED structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static Fixed parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UINT16 integer = parseUINT16(parser, 0x00006, fieldName + "::Integer");
		final UINT16 decimal = parseUINT16(parser, 0x00006, fieldName + "::Decimal");

		return new Fixed(integer, decimal);
	}
}