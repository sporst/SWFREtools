package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseBits;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlag;
import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses BevelFilter structures.
 * 
 * @author sp
 */
public final class BevelFilterParser {

	/**
	 * Parses a BevelFilter structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static BevelFilter parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final RGBA shadowColor = RGBAParser.parse(parser, fieldName + "::ShadowColor");
		final RGBA highlightColor = RGBAParser.parse(parser, fieldName + "::HighlightColor");
		final Fixed blurX = FixedParser.parse(parser, fieldName + "::BlurX");
		final Fixed blurY = FixedParser.parse(parser, fieldName + "::BlurY");
		final Fixed angle = FixedParser.parse(parser, fieldName + "::Angle");
		final Fixed distance = FixedParser.parse(parser, fieldName + "::Distance");
		final Fixed8 strength = Fixed8Parser.parse(parser, fieldName + "::Strength");
		final Flag innerShadow = parseFlag(parser, 0x00006, fieldName + "::InnerShadow");
		final Flag knockout = parseFlag(parser, 0x00006, fieldName + "::Knockout");
		final Flag compositeSource = parseFlag(parser, 0x00006, fieldName + "::CompositeSource");
		final Flag onTop = parseFlag(parser, 0x00006, fieldName + "::OnTop");
		final Bits passes = parseBits(parser, 4, 0x00006, fieldName + "::Passes");

		return new BevelFilter(shadowColor, highlightColor, blurX, blurY, angle, distance, strength, innerShadow, knockout, compositeSource, onTop, passes);
	}
}