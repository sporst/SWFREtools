package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

public class MorphLineStyleParser {

	public static MorphLineStyle parse(final BinaryParser parser) {
		final int startWidth = parser.readUInt8();
		final RGBA startColor = RGBAParser.parse(parser);
		final int endWidth = parser.readUInt8();
		final RGBA endColor = RGBAParser.parse(parser);

		return new MorphLineStyle(startWidth, startColor, endWidth, endColor);
	}

}
