package tv.porst.swfretools.parser.actions.as3;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT32;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;
import tv.porst.splib.binaryparser.UINT32;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses ActionScript 3 'hasnext2' instructions.
 */
public final class AS3Hasnext2Parser {

	public static AS3Hasnext2 parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {
		final UINT8 opcode = parseUINT8(parser, 0x00006, fieldName + "::opcode");
		final UINT32 objectReg = parseUINT32(parser, 0x00006, fieldName + "::object_reg");
		final UINT32 indexReg = parseUINT32(parser, 0x00006, fieldName + "::index_reg");

		return new AS3Hasnext2(opcode, objectReg, indexReg);
	}
}
