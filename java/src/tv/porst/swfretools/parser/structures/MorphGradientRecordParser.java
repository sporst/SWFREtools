package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

public class MorphGradientRecordParser {

	public static MorphGradientRecord parse(final BinaryParser parser) {
		final int startRatio = parser.readUInt8();
		final RGBA startColor = RGBAParser.parse(parser);
		final int endRatio = parser.readUInt8();
		final RGBA endColor = RGBAParser.parse(parser);

		return new MorphGradientRecord(startRatio, startColor, endRatio, endColor);
	}

}
