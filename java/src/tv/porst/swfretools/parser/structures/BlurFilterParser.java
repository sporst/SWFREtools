package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

public class BlurFilterParser {

	public static BlurFilter parse(final BinaryParser parser) {
		final Fixed blurX = FixedParser.parse(parser);
		final Fixed blurY = FixedParser.parse(parser);
		final int passes = parser.readBits(5);
		final int reserved = parser.readBits(3);

		return new BlurFilter(blurX, blurY, passes, reserved);
	}

}
