package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class BevelFilterParser {

	public static BevelFilter parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {
		final RGBA shadowColor = RGBAParser.parse(parser, fieldName + "::ShadowColor");
		final RGBA highlightColor = RGBAParser.parse(parser, fieldName + "::HighlightColor");
		final Fixed blurX = FixedParser.parse(parser, fieldName + "::BlurX");
		final Fixed blurY = FixedParser.parse(parser, fieldName + "::BlurY");
		final Fixed angle = FixedParser.parse(parser, fieldName + "::Angle");
		final Fixed distance = FixedParser.parse(parser, fieldName + "::Distance");
		final Fixed8 strength = Fixed8Parser.parse(parser, fieldName + "::Strength");
		final Flag innerShadow = parser.readFlag();
		final Flag knockout = parser.readFlag();
		final Flag compositeSource = parser.readFlag();
		final Flag onTop = parser.readFlag();
		final Bits passes = parser.readBits(4);

		return new BevelFilter(shadowColor, highlightColor, blurX, blurY, angle, distance, strength, innerShadow, knockout, compositeSource, onTop, passes);
	}

}
