package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;

public class RGBAParser {

	public static RGBA parse(final BinaryParser parser) {
		final UINT8 red = parser.readUInt8();
		final UINT8 green = parser.readUInt8();
		final UINT8 blue = parser.readUInt8();
		final UINT8 alpha = parser.readUInt8();

		return new RGBA(red, green, blue, alpha);
	}

	public static RGBA parseIf(final SWFBinaryParser parser, final Flag condition, final String fieldName) {
		return condition.value() ? parse(parser) : null;
	}

}
