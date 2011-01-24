package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseBits;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlag;
import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses GlowFilter structures.
 * 
 * @author sp
 */
public final class GlowFilterParser {

	/**
	 * Parses a GlowFilter structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static GlowFilter parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final RGBA glowColor = RGBAParser.parse(parser, fieldName + "::GlowColor");
		final Fixed blurX = FixedParser.parse(parser, fieldName + "::BlurX");
		final Fixed blurY = FixedParser.parse(parser, fieldName + "::BlurY");
		final Fixed8 strength = Fixed8Parser.parse(parser, fieldName + "::Strength");
		final Flag innerShadow = parseFlag(parser, 0x00006, fieldName + "::InnerShadow");
		final Flag knockout = parseFlag(parser, 0x00006, fieldName + "::KnockOut");
		final Flag compositeSource = parseFlag(parser, 0x00006, fieldName + "::CompositeSource");
		final Bits passes = parseBits(parser, 5, 0x00006, fieldName + "::Passes");

		return new GlowFilter(glowColor, blurX, blurY, strength, innerShadow, knockout, compositeSource, passes);
	}
}