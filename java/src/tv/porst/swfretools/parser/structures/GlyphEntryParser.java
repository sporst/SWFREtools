package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUBits;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseSBits;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.Bits;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses GlyphEntry structures.
 * 
 * @author sp
 *
 */
public final class GlyphEntryParser {

	/**
	 * Parses a GlyphEntry structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param glyphBits Number of glyph bits.
	 * @param advanceBits Number of advance bits.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static GlyphEntry parse(final SWFBinaryParser parser, final int glyphBits, final int advanceBits, final String fieldName) throws SWFParserException {
		final UBits glyphIndex = parseUBits(parser, glyphBits, 0x00006, fieldName + "::GlyphIndex");
		final Bits advanceIndex = parseSBits(parser, advanceBits, 0x00006, fieldName + "::AdvanceIndex");

		return new GlyphEntry(glyphIndex, advanceIndex);
	}
}