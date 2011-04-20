package tv.porst.swfretools.parser.actions.as3;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseINT24;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;
import tv.porst.splib.binaryparser.INT24;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses ActionScript 3 'iffalse' instructions.
 */
public final class AS3IffalseParser {

	public static AS3Iffalse parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {
		final UINT8 opcode = parseUINT8(parser, 0x00006, fieldName + "::opcode");
		final INT24 offset = parseINT24(parser, 0x00006, fieldName + "::offset");

		return new AS3Iffalse(opcode, offset);
	}
}
