package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseBits;
import tv.porst.splib.io.Bits;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses BlurFilter structures.
 * 
 * @author sp
 */
public final class BlurFilterParser {

	/**
	 * Parses a BlurFilter structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static BlurFilter parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final Fixed blurX = FixedParser.parse(parser, fieldName + "::BlurX");
		final Fixed blurY = FixedParser.parse(parser, fieldName + "::BlurY");
		final Bits passes = parseBits(parser, 5, 0x00006, fieldName + "::Passes");
		final Bits reserved = parseBits(parser, 5, 0x00006, fieldName + "::Reserved");

		return new BlurFilter(blurX, blurY, passes, reserved);
	}
}