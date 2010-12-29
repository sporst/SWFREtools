package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

public class RGBParser {

	public static RGB parse(final BinaryParser parser) {
		final int red = parser.readUInt8();
		final int green = parser.readUInt8();
		final int blue = parser.readUInt8();

		return new RGB(red, green, blue);
	}

}
