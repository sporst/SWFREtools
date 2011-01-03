package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.UINT8;

public class GradRecord3Parser {

	public static GradRecord3 parse(final BinaryParser parser) {
		final UINT8 ratio = parser.readUInt8();
		final RGBA color = RGBAParser.parse(parser);

		return new GradRecord3(ratio, color);
	}

}
