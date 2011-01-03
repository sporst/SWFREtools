package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.UINT8;

public class RGBAParser {

	public static RGBA parse(final BinaryParser parser) {
		final UINT8 red = parser.readUInt8();
		final UINT8 green = parser.readUInt8();
		final UINT8 blue = parser.readUInt8();
		final UINT8 alpha = parser.readUInt8();

		return new RGBA(red, green, blue, alpha);
	}

}
