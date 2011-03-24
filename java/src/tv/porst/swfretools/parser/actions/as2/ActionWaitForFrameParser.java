package tv.porst.swfretools.parser.actions.as2;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class ActionWaitForFrameParser {

	public static ActionWaitForFrame parse(final SWFBinaryParser parser, final UINT8 actionCode, final String fieldName) throws SWFParserException {
		final UINT16 length = parseUINT16(parser, 0x00006, fieldName + "::Length");
		final UINT16 frame = parseUINT16(parser, 0x00006, fieldName + "::Frame");
		final UINT8 skipCount = parseUINT8(parser, 0x00006, fieldName + "::SkipCount");

		return new ActionWaitForFrame(actionCode, length, frame, skipCount);
	}
}
