package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

public class BevelFilterParser {

	public static BevelFilter parse(final BinaryParser parser) {
		final RGBA shadowColor = RGBAParser.parse(parser);
		final RGBA highlightColor = RGBAParser.parse(parser);
		final Fixed blurX = FixedParser.parse(parser);
		final Fixed blurY = FixedParser.parse(parser);
		final Fixed angle = FixedParser.parse(parser);
		final Fixed distance = FixedParser.parse(parser);
		final Fixed8 strength = Fixed8Parser.parse(parser);
		final boolean innerShadow = parser.readFlag();
		final boolean knockout = parser.readFlag();
		final boolean compositeSource = parser.readFlag();
		final boolean onTop = parser.readFlag();
		final int passes = parser.readBits(4);

		return new BevelFilter(shadowColor, highlightColor, blurX, blurY, angle, distance, strength, innerShadow, knockout, compositeSource, onTop, passes);
	}

}
