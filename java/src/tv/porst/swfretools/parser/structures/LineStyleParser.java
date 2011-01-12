package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class LineStyleParser {

	public static LineStyle parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UINT8 lineStyleType = parser.readUInt8();
		final RGB color = RGBParser.parse(parser, fieldName + "::Color");

		return new LineStyle(lineStyleType, color);

	}
}
