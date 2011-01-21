package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class GradRecord3Parser {

	public static GradRecord3 parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {
		final UINT8 ratio = parser.readUInt8();
		final RGBA color = RGBAParser.parse(parser, fieldName + "::Color");

		return new GradRecord3(ratio, color);
	}

}
