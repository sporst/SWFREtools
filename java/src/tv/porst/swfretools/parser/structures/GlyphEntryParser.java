package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.Bits;
import tv.porst.splib.io.SBits;

public class GlyphEntryParser {

	public static GlyphEntry parse(final BinaryParser parser, final int glyphBits, final int advanceBits) {
		final Bits glyphIndex = parser.readBits(glyphBits);
		final SBits advanceIndex = parser.readSBits(glyphBits);

		return new GlyphEntry(glyphIndex, advanceIndex);
	}

}
