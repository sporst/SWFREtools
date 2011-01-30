package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses FIXED8 structures.
 * 
 * @author sp
 *
 */
public final class Fixed8Parser {

	/**
	 * Parses a FIXED8 structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static Fixed8 parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UINT8 integer = parseUINT8(parser, 0x00006, fieldName + "::Integer");
		final UINT8 decimal = parseUINT8(parser, 0x00006, fieldName + "::Decimal");

		return new Fixed8(integer, decimal);
	}
}
