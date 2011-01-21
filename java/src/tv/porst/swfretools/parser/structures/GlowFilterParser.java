package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class GlowFilterParser {

	public static GlowFilter parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {
		final RGBA glowColor = RGBAParser.parse(parser, fieldName + "::GlowColor");
		final Fixed blurX = FixedParser.parse(parser);
		final Fixed blurY = FixedParser.parse(parser);
		final Fixed8 strength = Fixed8Parser.parse(parser);
		final Flag innerShadow = parser.readFlag();
		final Flag knockout = parser.readFlag();
		final Flag compositeSource = parser.readFlag();
		final Bits passes = parser.readBits(5);

		return new GlowFilter(glowColor, blurX, blurY, strength, innerShadow, knockout, compositeSource, passes);
	}

}
