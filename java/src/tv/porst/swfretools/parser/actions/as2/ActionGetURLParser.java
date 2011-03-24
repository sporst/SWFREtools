package tv.porst.swfretools.parser.actions.as2;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseString;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class ActionGetURLParser {

	public static ActionGetURL parse(final SWFBinaryParser parser, final UINT8 actionCode, final String fieldName) throws SWFParserException {
		final UINT16 length = parseUINT16(parser, 0x00006, fieldName + "::Length");
		final AsciiString urlString = parseString(parser, 0x00006, "::UrlString");
		final AsciiString targetString = parseString(parser, 0x00006, "::TargetString");

		return new ActionGetURL(actionCode, length, urlString, targetString);
	}

}
