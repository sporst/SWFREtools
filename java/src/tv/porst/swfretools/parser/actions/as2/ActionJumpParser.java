package tv.porst.swfretools.parser.actions.as2;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseINT16;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import tv.porst.splib.binaryparser.INT16;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class ActionJumpParser {

	public static ActionJump parse(final SWFBinaryParser parser, final UINT8 actionCode, final String fieldName) throws SWFParserException {
		final UINT16 length = parseUINT16(parser, 0x00006, fieldName + "::Length");
		final INT16 branchOffset = parseINT16(parser, 0x00006, fieldName + "::BranchOffset");

		return new ActionJump(actionCode, length, branchOffset);
	}

}
