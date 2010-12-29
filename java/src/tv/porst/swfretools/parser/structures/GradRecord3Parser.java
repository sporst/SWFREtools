package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

public class GradRecord3Parser {

	public static GradRecord3 parse(final BinaryParser parser) {
		final int ratio = parser.readUInt8();
		final RGBA color = RGBAParser.parse(parser);

		return new GradRecord3(ratio, color);
	}

}
