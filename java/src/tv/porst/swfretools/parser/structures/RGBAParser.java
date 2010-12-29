package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

public class RGBAParser {

	public static RGBA parse(final BinaryParser parser) {
		final int red = parser.readUInt8();
		final int green = parser.readUInt8();
		final int blue = parser.readUInt8();
		final int alpha = parser.readUInt8();

		return new RGBA(red, green, blue, alpha);
	}

}
