package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.UINT8;

public class GradientBevelFilterParser {

	public static GradientBevelFilter parse(final BinaryParser parser) {
		final UINT8 numColors = parser.readUInt8();

		final RGBA[] gradientColors = new RGBA[numColors.value()];

		for (int i=0;i<numColors.value();i++) {
			gradientColors[i] = RGBAParser.parse(parser);
		}

		final UINT8[] gradientRatio = new UINT8[numColors.value()];

		for (int i=0;i<numColors.value();i++) {
			gradientRatio[i] = parser.readUInt8();
		}

		final Fixed blurX = FixedParser.parse(parser);
		final Fixed blurY = FixedParser.parse(parser);
		final Fixed angle = FixedParser.parse(parser);
		final Fixed distance = FixedParser.parse(parser);
		final Fixed8 strength = Fixed8Parser.parse(parser);
		final Flag innerShadow = parser.readFlag();
		final Flag knockout = parser.readFlag();
		final Flag compositeSource = parser.readFlag();
		final Flag onTop = parser.readFlag();
		final Bits passes = parser.readBits(4);

		return new GradientBevelFilter(numColors, gradientColors, gradientRatio, blurX, blurY, angle, distance, strength, innerShadow, knockout, compositeSource, onTop, passes);
	}

}
