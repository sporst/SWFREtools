package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class MorphGradientRecordParser {

	public static MorphGradientRecord parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {
		final UINT8 startRatio = parser.readUInt8();
		final RGBA startColor = RGBAParser.parse(parser, fieldName + "::StartColor");
		final UINT8 endRatio = parser.readUInt8();
		final RGBA endColor = RGBAParser.parse(parser, fieldName + "::EndColor");

		return new MorphGradientRecord(startRatio, startColor, endRatio, endColor);
	}

}
