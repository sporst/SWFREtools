package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

public class DropShadowFilterParser {

	public static DropShadowFilter parse(final BinaryParser parser) {

		final RGBA dropShadowColor = RGBAParser.parse(parser);
		final Fixed blurX = FixedParser.parse(parser);
		final Fixed blurY = FixedParser.parse(parser);
		final Fixed angle = FixedParser.parse(parser);
		final Fixed distance = FixedParser.parse(parser);
		final Fixed8 strength = Fixed8Parser.parse(parser);
		final boolean innerShadow = parser.readFlag();
		final boolean knockout = parser.readFlag();
		final boolean compositeSource = parser.readFlag();
		final int passes = parser.readBits(5);

		return new DropShadowFilter(dropShadowColor, blurX, blurY, angle, distance, strength, innerShadow, knockout, compositeSource, passes);
	}

}
