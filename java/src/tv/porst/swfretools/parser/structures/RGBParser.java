package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class RGBParser {

	public static RGB parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UINT8 red = parseUINT8(parser, 0x00006, fieldName + "::Red");
		final UINT8 green = parseUINT8(parser, 0x00006, fieldName + "::Green");
		final UINT8 blue = parseUINT8(parser, 0x00006, fieldName + "::Blue");

		return new RGB(red, green, blue);
	}

}
