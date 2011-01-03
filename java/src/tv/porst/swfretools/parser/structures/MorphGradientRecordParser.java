package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.UINT8;

public class MorphGradientRecordParser {

	public static MorphGradientRecord parse(final BinaryParser parser) {
		final UINT8 startRatio = parser.readUInt8();
		final RGBA startColor = RGBAParser.parse(parser);
		final UINT8 endRatio = parser.readUInt8();
		final RGBA endColor = RGBAParser.parse(parser);

		return new MorphGradientRecord(startRatio, startColor, endRatio, endColor);
	}

}
