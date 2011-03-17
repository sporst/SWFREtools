package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.splib.binaryparser.INT16;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;

/**
 * Represents a TextRecord2 structure.
 * 
 * @author sp
 *
 */
public final class TextRecord2 implements IFileElement {

	/**
	 * Type of the text record.
	 */
	private final Flag textRecordType;

	/**
	 * Reserved bits.
	 */
	private final UBits styleFlagsReserved;

	/**
	 * Font specified flag.
	 */
	private final Flag styleFlagsHasFont;

	/**
	 * Color specified flag.
	 */
	private final Flag styleFlagsHasColor;

	/**
	 * YOffset specified flag.
	 */
	private final Flag styleFlagsHasYOffset;

	/**
	 * XOffset specified flag.
	 */
	private final Flag styleFlagsHasXOffset;

	/**
	 * Font ID for following text.
	 */
	private final UINT16 fontId;

	/**
	 * Font color for following text.
	 */
	private final RGBA textColor;

	/**
	 * X offset for following text.
	 */
	private final INT16 xOffset;

	/**
	 * Y offset for following text.
	 */
	private final INT16 yOffset;

	/**
	 * Font height for following text.
	 */
	private final UINT16 textHeight;

	/**
	 * Number of glyphs in record.
	 */
	private final UINT8 glyphCount;

	/**
	 * List of glyph entries.
	 */
	private final GlyphEntryList glyphEntries;

	/**
	 * Creates a new TextRecord object.
	 * 
	 * @param textRecordType Type of the text record.
	 * @param styleFlagsReserved Reserved bits.
	 * @param styleFlagsHasFont Font specified flag.
	 * @param styleFlagsHasColor Color specified flag.
	 * @param styleFlagsHasYOffset YOffset specified flag.
	 * @param styleFlagsHasXOffset XOffset specified flag.
	 * @param fontId Font ID for following text.
	 * @param textColor Font color for following text.
	 * @param xOffset X offset for following text.
	 * @param yOffset Y offset for following text.
	 * @param textHeight Font height for following text.
	 * @param glyphCount Number of glyphs in record.
	 * @param glyphEntries List of glyph entries.
	 */
	public TextRecord2(final Flag textRecordType, final UBits styleFlagsReserved,
			final Flag styleFlagsHasFont, final Flag styleFlagsHasColor,
			final Flag styleFlagsHasYOffset, final Flag styleFlagsHasXOffset,
			final UINT16 fontId, final RGBA textColor, final INT16 xOffset, final INT16 yOffset,
			final UINT16 textHeight, final UINT8 glyphCount, final GlyphEntryList glyphEntries) {

		this.textRecordType = textRecordType;
		this.styleFlagsReserved = styleFlagsReserved;
		this.styleFlagsHasFont = styleFlagsHasFont;
		this.styleFlagsHasColor = styleFlagsHasColor;
		this.styleFlagsHasYOffset = styleFlagsHasYOffset;
		this.styleFlagsHasXOffset = styleFlagsHasXOffset;
		this.fontId = fontId;
		this.textColor = textColor;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.textHeight = textHeight;
		this.glyphCount = glyphCount;
		this.glyphEntries = glyphEntries;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(textRecordType, styleFlagsReserved, styleFlagsHasFont,
				styleFlagsHasColor, styleFlagsHasYOffset, styleFlagsHasXOffset, fontId, textColor,
				xOffset, yOffset, textHeight, glyphCount, glyphEntries);
	}

	@Override
	public int getBitPosition() {
		return textRecordType.getBitPosition();
	}

	/**
	 * Returns the font ID for following text.
	 *
	 * @return The font ID for following text.
	 */
	public UINT16 getFontId() {
		return fontId;
	}

	/**
	 * Returns the number of glyphs in record.
	 *
	 * @return The number of glyphs in record.
	 */
	public UINT8 getGlyphCount() {
		return glyphCount;
	}

	/**
	 * Returns the list of glyph entries.
	 *
	 * @return The list of glyph entries.
	 */
	public GlyphEntryList getGlyphEntries() {
		return glyphEntries;
	}

	/**
	 * Returns the color specified flag.
	 *
	 * @return The color specified flag.
	 */
	public Flag getStyleFlagsHasColor() {
		return styleFlagsHasColor;
	}

	/**
	 * Returns the font specified flag.
	 *
	 * @return The font specified flag.
	 */
	public Flag getStyleFlagsHasFont() {
		return styleFlagsHasFont;
	}

	/**
	 * Returns the XOffset specified flag.
	 *
	 * @return The XOffset specified flag.
	 */
	public Flag getStyleFlagsHasXOffset() {
		return styleFlagsHasXOffset;
	}

	/**
	 * Returns the YOffset specified flag.
	 *
	 * @return The YOffset specified flag.
	 */
	public Flag getStyleFlagsHasYOffset() {
		return styleFlagsHasYOffset;
	}

	/**
	 * Returns the reserved bits.
	 *
	 * @return The reserved bits.
	 */
	public UBits getStyleFlagsReserved() {
		return styleFlagsReserved;
	}

	/**
	 * Returns the font color for following text.
	 *
	 * @return The font color for following text.
	 */
	public RGBA getTextColor() {
		return textColor;
	}

	/**
	 * Returns the font height for following text.
	 *
	 * @return The font height for following text.
	 */
	public UINT16 getTextHeight() {
		return textHeight;
	}

	/**
	 * Returns the type of the text record.
	 *
	 * @return The type of the text record.
	 */
	public Flag getTextRecordType() {
		return textRecordType;
	}

	/**
	 * Returns the X offset for following text.
	 *
	 * @return The X offset for following text.
	 */
	public INT16 getxOffset() {
		return xOffset;
	}

	/**
	 * Returns the Y offset for following text.
	 *
	 * @return The Y offset for following text.
	 */
	public INT16 getyOffset() {
		return yOffset;
	}
}