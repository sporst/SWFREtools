package tv.porst.swfretools.parser.actions.as3;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses ActionScript 3 'pushbyte' instructions.
 */
public final class AS3PushbyteParser {

	public static AS3Pushbyte parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {
		final UINT8 opcode = parseUINT8(parser, 0x00006, fieldName + "::opcode");
		final UINT8 byteValue = parseUINT8(parser, 0x00006, fieldName + "::byte_value");

		return new AS3Pushbyte(opcode, byteValue);
	}
}
