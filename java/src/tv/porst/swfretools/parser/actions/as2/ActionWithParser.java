package tv.porst.swfretools.parser.actions.as2;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class ActionWithParser {

	public static ActionWith parse(final SWFBinaryParser parser, final UINT8 actionCode, final String fieldName) throws SWFParserException {
		final UINT16 length = parseUINT16(parser, 0x00006, fieldName + "::Length");
		final UINT16 size = parseUINT16(parser, 0x00006, fieldName + "::Size");

		return new ActionWith(actionCode, length, size);
	}

}
