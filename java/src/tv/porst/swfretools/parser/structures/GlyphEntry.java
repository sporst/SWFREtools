package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.Bits;
import tv.porst.splib.io.SBits;

/**
 * Represents a GlyphEntry structure.
 * 
 * @author sp
 *
 */
public final class GlyphEntry {

	/**
	 * Glyph index into current font.
	 */
	private final Bits glyphIndex;

	/**
	 * X advance value for glyph.
	 */
	private final SBits advanceIndex;

	/**
	 * Creates a new GlyphEntry object.
	 * 
	 * @param glyphIndex Glyph index into current font.
	 * @param advanceIndex X advance value for glyph.
	 */
	public GlyphEntry(final Bits glyphIndex, final SBits advanceIndex) {

		this.glyphIndex = glyphIndex;
		this.advanceIndex = advanceIndex;
	}

	/**
	 * Returns the X advance value for glyph.
	 *
	 * @return The X advance value for glyph.
	 */
	public SBits getAdvanceIndex() {
		return advanceIndex;
	}

	/**
	 * Returns the glyph index into current font.
	 *
	 * @return The glyph index into current font.
	 */
	public Bits getGlyphIndex() {
		return glyphIndex;
	}
}