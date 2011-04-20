package tv.porst.swfretools.parser.actions.as3;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses an ActionScript 3 'urshift' instruction.
 */
public final class AS3UrshiftParser {

	/**
	 * Parses an ActionScript 3 'urshift' instruction.
	 * 
	 * @param parser Parsed that parses the instruction.
	 * @param fieldName Name of the parsed field.
	 * 
	 * @return The parsed instruction.
	 * 
	 * @throws SWFParserException Thrown if the instruction could not be parsed.
	 */
	public static AS3Urshift parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {
		final UINT8 opcode = parseUINT8(parser, 0x00006, fieldName + "::opcode");

		return new AS3Urshift(opcode);
	}
}