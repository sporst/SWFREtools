package tv.porst.swfretools.parser.actions.as2;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlag;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUBits;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16If;
import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class ActionGotoFrame2Parser {

	public static ActionGotoFrame2 parse(final SWFBinaryParser parser, final UINT8 actionCode, final String fieldName) throws SWFParserException {
		final UINT16 length = parseUINT16(parser, 0x00006, fieldName + "::Length");
		final UBits reserved = parseUBits(parser, 6, 0x00006, fieldName + "::Reserved");
		final Flag sceneBiasFlag = parseFlag(parser, 0x00006, fieldName + "::SceneBiasFlag");
		final Flag playFlag = parseFlag(parser, 0x00006, fieldName + "::PlayFlag");
		final UINT16 sceneBias = parseUINT16If(parser, 0x00006, sceneBiasFlag, fieldName + "::SceneBias");

		return new ActionGotoFrame2(actionCode, length, reserved, sceneBiasFlag, playFlag, sceneBias);
	}

}
