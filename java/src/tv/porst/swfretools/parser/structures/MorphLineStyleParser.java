package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.UINT8;

public class MorphLineStyleParser {

	public static MorphLineStyle parse(final BinaryParser parser) {
		final UINT8 startWidth = parser.readUInt8();
		final RGBA startColor = RGBAParser.parse(parser);
		final UINT8 endWidth = parser.readUInt8();
		final RGBA endColor = RGBAParser.parse(parser);

		return new MorphLineStyle(startWidth, startColor, endWidth, endColor);
	}

}
