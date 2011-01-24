package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class DropShadowFilterParser {

	public static DropShadowFilter parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final RGBA dropShadowColor = RGBAParser.parse(parser, fieldName + "::DropShadowColor");
		final Fixed blurX = FixedParser.parse(parser, fieldName + "::BlurX");
		final Fixed blurY = FixedParser.parse(parser, fieldName + "::BlurY");
		final Fixed angle = FixedParser.parse(parser, fieldName + "::Angle");
		final Fixed distance = FixedParser.parse(parser, fieldName + "::Distance");
		final Fixed8 strength = Fixed8Parser.parse(parser, fieldName + "::Strength");
		final Flag innerShadow = parser.readFlag();
		final Flag knockout = parser.readFlag();
		final Flag compositeSource = parser.readFlag();
		final Bits passes = parser.readBits(5);

		return new DropShadowFilter(dropShadowColor, blurX, blurY, angle, distance, strength, innerShadow, knockout, compositeSource, passes);
	}

}
