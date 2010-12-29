package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

public class GradientBevelFilterParser {

	public static GradientBevelFilter parse(final BinaryParser parser) {
		final int numColors = parser.readUInt8();

		final RGBA[] gradientColors = new RGBA[numColors];

		for (int i=0;i<numColors;i++) {
			gradientColors[i] = RGBAParser.parse(parser);
		}

		final int[] gradientRatio = new int[numColors];

		for (int i=0;i<numColors;i++) {
			gradientRatio[i] = parser.readUInt8();
		}

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

		return new GradientBevelFilter(numColors, gradientColors, gradientRatio, blurX, blurY, angle, distance, strength, innerShadow, knockout, compositeSource, onTop, passes);
	}

}
