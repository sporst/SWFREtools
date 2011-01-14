package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;

public class DropShadowFilterParser {

	public static DropShadowFilter parse(final BinaryParser parser) {

		final RGBA dropShadowColor = RGBAParser.parse(parser);
		final Fixed blurX = FixedParser.parse(parser);
		final Fixed blurY = FixedParser.parse(parser);
		final Fixed angle = FixedParser.parse(parser);
		final Fixed distance = FixedParser.parse(parser);
		final Fixed8 strength = Fixed8Parser.parse(parser);
		final Flag innerShadow = parser.readFlag();
		final Flag knockout = parser.readFlag();
		final Flag compositeSource = parser.readFlag();
		final Bits passes = parser.readBits(5);

		return new DropShadowFilter(dropShadowColor, blurX, blurY, angle, distance, strength, innerShadow, knockout, compositeSource, passes);
	}

}
