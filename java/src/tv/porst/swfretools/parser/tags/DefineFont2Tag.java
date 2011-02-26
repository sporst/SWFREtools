package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.INT16;
import tv.porst.splib.binaryparser.IParsedINTElement;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.structures.INT16List;
import tv.porst.swfretools.parser.structures.KerningRecordList;
import tv.porst.swfretools.parser.structures.ParsedINTElementList;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.RectList;
import tv.porst.swfretools.parser.structures.ShapeList;

/**
 * Represents a DefineFont2 tag.
 * 
 * @author sp
 *
 */
public final class DefineFont2Tag extends Tag {

	/**
	 * ID of this font character.
	 */
	private final UINT16 fontId;

	/**
	 * Array of shape offsets.
	 */
	private final ParsedINTElementList offsetTable;

	/**
	 * Array of shapes.
	 */
	private final ShapeList glyphShapeTable;

	/**
	 * Length of font name.
	 */
	private final UINT8 fontNameLen;

	/**
	 * Name of the font.
	 */
	private final AsciiString fontName;

	/**
	 * Count of glyphs in font.
	 */
	private final UINT16 numGlyphs;

	/**
	 * Font is small flag.
	 */
	private final Flag fontFlagsSmallText;

	/**
	 * Byte count from start of offset table to start of code table.
	 */
	private final IParsedINTElement codeTableOffset;

	/**
	 * ShiftJIS character codes flag.
	 */
	private final Flag fontFlagsShiftJIS;

	/**
	 * ANSI character codes flag.
	 */
	private final Flag fontFlagsANSI;

	/**
	 * Italic font flag.
	 */
	private final Flag fontFlagsItalic;

	/**
	 * Bold font flag.
	 */
	private final Flag fontFlagsBold;

	/**
	 * Wide codes flag.
	 */
	private final Flag fontFlagsWideCodes;

	/**
	 * Language ID.
	 */
	private final UINT8 languageCode;

	/**
	 * Has layout information flag.
	 */
	private final Flag fontFlagsHasLayout;

	/**
	 * Glyph to code table.
	 */
	private final ParsedINTElementList codeTable;

	/**
	 * Wide offsets flag.
	 */
	private final Flag fontFlagsWideOffsets;

	/**
	 * Font ascender height.
	 */
	private final INT16 fontAscent;

	/**
	 * Font descender height.
	 */
	private final INT16 fontDescent;

	/**
	 * Font leading height.
	 */
	private final INT16 fontLeading;

	/**
	 * Advance value to be used for each glyph in dynamic glyph text.
	 */
	private final INT16List fontAdvanceTable;

	/**
	 * Font bounds table.
	 */
	private final RectList fontBoundsTable;

	/**
	 * Kerning count.
	 */
	private final UINT16 kerningCount;

	/**
	 * Font kerning table.
	 */
	private final KerningRecordList fontKerningTable;

	/**
	 * Creates a new DefineFont2 tag object.
	 * 
	 * @param header Tag header.
	 * @param fontId Font ID this information is for.
	 * @param fontFlagsHasLayout Has layout information flag.
	 * @param fontFlagsShiftJIS ShiftJIS character codes flag.
	 * @param fontFlagsSmallText Font is small flag.
	 * @param fontFlagsANSI ANSI character code flags.
	 * @param fontFlagsWideCodes Wide codes flag.
	 * @param fontFlagsWideOffsets Wide offsets flag.
	 * @param fontFlagsItalic Italic font flag.
	 * @param fontFlagsBold Bold font flag.
	 * @param languageCode Language ID.
	 * @param fontNameLen Length of font name.
	 * @param fontName Name of the font.
	 * @param numGlyphs Count of glyphs in font.
	 * @param codeTable Glyph to code table.
	 * @param offsetTable Offset table.
	 * @param codeTableOffset Byte count from start of offset table	to start of code table.
	 * @param glyphShapeTable Glyph shape table.
	 * @param fontAscent Font ascender height.
	 * @param fontDescent Font descender height.
	 * @param fontLeading Font leading height.
	 * @param fontAdvanceTable Advance values to be used for each glyph in dynamic glyph text.
	 * @param fontBoundsTable Font bounds table.
	 * @param kerningCount Kerning count.
	 * @param fontKerningTable Font kerning table.
	 */
	public DefineFont2Tag(final RecordHeader header, final UINT16 fontId,
			final Flag fontFlagsHasLayout, final Flag fontFlagsShiftJIS,
			final Flag fontFlagsSmallText, final Flag fontFlagsANSI,
			final Flag fontFlagsWideOffsets, final Flag fontFlagsWideCodes,
			final Flag fontFlagsItalic, final Flag fontFlagsBold, final UINT8 languageCode,
			final UINT8 fontNameLen, final AsciiString fontName, final UINT16 numGlyphs,
			final ParsedINTElementList offsetTable, final IParsedINTElement codeTableOffset,
			final ShapeList glyphShapeTable, final ParsedINTElementList codeTable,
			final INT16 fontAscent, final INT16 fontDescent, final INT16 fontLeading,
			final INT16List fontAdvanceTable, final RectList fontBoundsTable,
			final UINT16 kerningCount, final KerningRecordList fontKerningTable) {
		super(header);

		this.fontId = fontId;
		this.fontFlagsHasLayout = fontFlagsHasLayout;
		this.fontFlagsShiftJIS = fontFlagsShiftJIS;
		this.fontFlagsSmallText = fontFlagsSmallText;
		this.fontFlagsANSI = fontFlagsANSI;
		this.fontFlagsWideOffsets = fontFlagsWideOffsets;
		this.fontFlagsWideCodes = fontFlagsWideCodes;
		this.fontFlagsItalic = fontFlagsItalic;
		this.fontFlagsBold = fontFlagsBold;
		this.languageCode = languageCode;
		this.fontNameLen = fontNameLen;
		this.fontName = fontName;
		this.numGlyphs = numGlyphs;
		this.offsetTable = offsetTable;
		this.codeTableOffset = codeTableOffset;
		this.glyphShapeTable = glyphShapeTable;
		this.codeTable = codeTable;
		this.fontAscent = fontAscent;
		this.fontDescent = fontDescent;
		this.fontLeading = fontLeading;
		this.fontAdvanceTable = fontAdvanceTable;
		this.fontBoundsTable = fontBoundsTable;
		this.kerningCount = kerningCount;
		this.fontKerningTable = fontKerningTable;
	}

	/**
	 * Returns the glyph to code table.
	 * 
	 * @return The glyph to code table.
	 */
	public ParsedINTElementList getCodeTable() {
		return codeTable;
	}

	/**
	 * Returns the byte count from start of offset table to start of code table.
	 * 
	 * @return The byte count from start of offset table to start of code table.
	 */
	public IParsedINTElement getCodeTableOffset() {
		return codeTableOffset;
	}

	/**
	 * Returns the advance values to be used for each glyph in dynamic glyph text.
	 * 
	 * @return The advance values to be used for each glyph in dynamic glyph text.
	 */
	public INT16List getFontAdvanceTable() {
		return fontAdvanceTable;
	}

	/**
	 * Returns the font ascender height.
	 * 
	 * @return The font ascender height.
	 */
	public INT16 getFontAscent() {
		return fontAscent;
	}

	/**
	 * Returns the font bounds table.
	 * 
	 * @return The font bounds table.
	 */
	public RectList getFontBoundsTable() {
		return fontBoundsTable;
	}

	/**
	 * Returns the font descender height.
	 * 
	 * @return The font descender height.
	 */
	public INT16 getFontDescent() {
		return fontDescent;
	}

	/**
	 * Returns the ANSI character code flags.
	 * 
	 * @return The ANSI character code flags.
	 */
	public Flag getFontFlagsANSI() {
		return fontFlagsANSI;
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
	 * Returns the has layout information flag.
	 * 
	 * @return The has layout information flag.
	 */
	public Flag getFontFlagsHasLayout() {
		return fontFlagsHasLayout;
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
	 * Returns the ShiftJIS character codes flag.
	 * 
	 * @return The ShiftJIS character codes flag.
	 */
	public Flag getFontFlagsShiftJIS() {
		return fontFlagsShiftJIS;
	}

	/**
	 * Returns the font is small flag.
	 * 
	 * @return The font is small flag.
	 */
	public Flag getFontFlagsSmallText() {
		return fontFlagsSmallText;
	}

	/**
	 * Returns the wide codes flag.
	 * 
	 * @return The wide codes flag.
	 */
	public Flag getFontFlagsWideCodes() {
		return fontFlagsWideCodes;
	}

	/**
	 * Returns the wide offsets flag.
	 * 
	 * @return The wide offsets flag.
	 */
	public Flag getFontFlagsWideOffsets() {
		return fontFlagsWideOffsets;
	}

	/**
	 * Returns the font ID this information is for.
	 * 
	 * @return The font ID this information is for.
	 */
	public UINT16 getFontId() {
		return fontId;
	}

	/**
	 * Returns the font kerning table.
	 * 
	 * @return The font kerning table.
	 */
	public KerningRecordList getFontKerningTable() {
		return fontKerningTable;
	}

	/**
	 * Returns the font leading height.
	 * 
	 * @return The font leading height.
	 */
	public INT16 getFontLeading() {
		return fontLeading;
	}

	/**
	 * Returns the name of the font.
	 * 
	 * @return The name of the font.
	 */
	public AsciiString getFontName() {
		return fontName;
	}

	/**
	 * Returns the length of font name.
	 * 
	 * @return The length of font name.
	 */
	public UINT8 getFontNameLen() {
		return fontNameLen;
	}

	/**
	 * Returns the glyph shape table.
	 * 
	 * @return The glyph shape table.
	 */
	public ShapeList getGlyphShapeTable() {
		return glyphShapeTable;
	}

	/**
	 * Returns the kerning count.
	 * 
	 * @return The kerning count.
	 */
	public UINT16 getKerningCount() {
		return kerningCount;
	}

	/**
	 * Returns the language ID.
	 * 
	 * @return The language ID.
	 */
	public UINT8 getLanguageCode() {
		return languageCode;
	}

	/**
	 * Returns the count of glyphs in font.
	 *
	 * @return The count of glyphs in font.
	 */
	public UINT16 getNumGlyphs() {
		return numGlyphs;
	}

	/**
	 * Returns the array of shape offsets.
	 * 
	 * @return The array of shape offsets.
	 */
	public ParsedINTElementList getOffsetTable() {
		return offsetTable;
	}
}