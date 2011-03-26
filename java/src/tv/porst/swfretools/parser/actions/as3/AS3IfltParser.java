package tv.porst.swfretools.parser.actions.as3;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.EncodedS24;
import tv.porst.swfretools.parser.structures.EncodedS24Parser;

public class AS3IfltParser {

	public static AS3Iflt parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {
		final UINT8 opcode = parseUINT8(parser, 0x00006, fieldName + "::opcode");
		final EncodedS24 offset = EncodedS24Parser.parse(parser, fieldName + "::offset");

		return new AS3Iflt(opcode, offset);
	}
}
