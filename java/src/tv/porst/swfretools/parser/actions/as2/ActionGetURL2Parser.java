package tv.porst.swfretools.parser.actions.as2;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlag;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUBits;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class ActionGetURL2Parser {

	public static ActionGetURL2 parse(final SWFBinaryParser parser, final UINT8 actionCode, final String fieldName) throws SWFParserException {
		final UINT16 length = parseUINT16(parser, 0x00006, fieldName + "::Length");
		final UBits sendVarsMethod = parseUBits(parser, 2, 0x00006, fieldName + "::SendVarsMethod");
		final UBits reserved = parseUBits(parser, 4, 0x00006, fieldName + "::Reserved");
		final Flag loadTargetFlag = parseFlag(parser, 0x00006, fieldName + "::LoadTargetFlag");
		final Flag loadVariablesFlag = parseFlag(parser, 0x00006, fieldName + "::LoadVariablesFlag");

		return new ActionGetURL2(actionCode, length, sendVarsMethod, reserved, loadTargetFlag, loadVariablesFlag);
	}

}
