package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class GradRecordParser {

	public static GradRecord parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {
		final UINT8 ratio = parser.readUInt8();
		final RGB color = RGBParser.parse(parser, fieldName + "::RGB");

		return new GradRecord(ratio, color);
	}

}
