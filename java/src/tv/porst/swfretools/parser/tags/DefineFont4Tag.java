package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.structures.ByteArray;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a DefineFont4 tag.
 */
public final class DefineFont4Tag extends Tag {

	/**
	 * ID of this font character.
	 */
	private final UINT16 fontId;

	/**
	 * Reserved bit fields.
	 */
	private final UBits fontFlagsReserved;

	/**
	 * Font is embedded flag.
	 */
	private final Flag fontFlagsHasFontData;

	/**
	 * Italic font flag.
	 */
	private final Flag fontFlagsItalic;

	/**
	 * Bold font flag.
	 */
	private final Flag fontFlagsBold;

	/**
	 * Name of the font.
	 */
	private final AsciiString fontName;

	/**
	 * Font data.
	 */
	private final ByteArray fontData;

	/**
	 * Creates a new DefineFont4 tag object.
	 * 
	 * @param header Tag header.
	 * @param fontId ID of this font character.
	 * @param fontFlagsReserved Reserved bit fields.
	 * @param fontFlagsHasFontData Font is embedded flag.
	 * @param fontFlagsItalic Italic font flag.
	 * @param fontFlagsBold Bold font flag.
	 * @param fontName Name of the font.
	 * @param fontData Font data.
	 */
	public DefineFont4Tag(final RecordHeader header, final UINT16 fontId,
			final UBits fontFlagsReserved, final Flag fontFlagsHasFontData,
			final Flag fontFlagsItalic, final Flag fontFlagsBold, final AsciiString fontName, final ByteArray fontData) {
		super(header);

		this.fontId = fontId;
		this.fontFlagsReserved = fontFlagsReserved;
		this.fontFlagsHasFontData = fontFlagsHasFontData;
		this.fontFlagsItalic = fontFlagsItalic;
		this.fontFlagsBold = fontFlagsBold;
		this.fontName = fontName;
		this.fontData = fontData;
	}

	/**
	 * Returns the font data.
	 * 
	 * @return The font data.
	 */
	public ByteArray getFontData() {
		return fontData;
	}

	/**
	 * Returns the bold font flag.
	 * 
	 * @return The bold font flag.
	 */
	public Flag getFontFlagsBold() {
		return fontFlagsBold;
	}

	/**
	 * Returns the font is embedded flag.
	 * 
	 * @return The font is embedded flag.
	 */
	public Flag getFontFlagsHasFontData() {
		return fontFlagsHasFontData;
	}

	/**
	 * Returns the italic font flag.
	 * 
	 * @return The italic font flag.
	 */
	public Flag getFontFlagsItalic() {
		return fontFlagsItalic;
	}

	/**
	 * Returns the reserved bit fields.
	 * 
	 * @return The reserved bit fields.
	 */
	public UBits getFontFlagsReserved() {
		return fontFlagsReserved;
	}

	/**
	 * Returns the ID of this font character.
	 * 
	 * @return The ID of this font character.
	 */
	public UINT16 getFontId() {
		return fontId;
	}

	/**
	 * Returns the name of the font.
	 * 
	 * @return The name of the font.
	 */
	public AsciiString getFontName() {
		return fontName;
	}
}