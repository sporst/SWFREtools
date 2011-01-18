package tv.porst.swfretools.parser.tags;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.Flag;
import tv.porst.splib.io.INT16;
import tv.porst.splib.io.IParsedINTElement;
import tv.porst.splib.io.PString;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.structures.KerningRecord;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.Shape3;

/**
 * Represents a DefineFont3 tag.
 * 
 * @author sp
 *
 */
public final class DefineFont3Tag extends Tag {

	/**
	 * ID of this font character.
	 */
	private final UINT16 fontId;

	/**
	 * Array of shape offsets.
	 */
	private final List<IParsedINTElement> offsetTable;

	/**
	 * Array of shapes.
	 */
	private final ArrayList<Shape3> glyphShapeTable;

	/**
	 * Length of font name.
	 */
	private final UINT8 fontNameLen;

	/**
	 * Name of the font.
	 */
	private final PString fontName;

	/**
	 * Font is small flag.
	 */
	private final Flag fontFlagsSmallText;

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
	private final List<IParsedINTElement> codeTable;

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
	private final List<INT16> fontAdvanceTable;

	/**
	 * Font bounds table.
	 */
	private final List<Rect> fontBoundsTable;

	/**
	 * Kerning count.
	 */
	private final UINT16 kerningCount;

	/**
	 * Font kerning table.
	 */
	private final List<KerningRecord> fontKerningTable;

	/**
	 * Creates a new DefineFont3 tag object.
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
	public DefineFont3Tag(final RecordHeader header, final UINT16 fontId,
			final Flag fontFlagsHasLayout, final Flag fontFlagsShiftJIS,
			final Flag fontFlagsSmallText, final Flag fontFlagsANSI,
			final Flag fontFlagsWideOffsets, final Flag fontFlagsWideCodes,
			final Flag fontFlagsItalic, final Flag fontFlagsBold, final UINT8 languageCode,
			final UINT8 fontNameLen, final PString fontName, final UINT16 numGlyphs,
			final List<IParsedINTElement> offsetTable,
			final IParsedINTElement codeTableOffset, final List<Shape3> glyphShapeTable,
			final List<IParsedINTElement> codeTable, final INT16 fontAscent,
			final INT16 fontDescent, final INT16 fontLeading, final List<INT16> fontAdvanceTable,
			final List<Rect> fontBoundsTable, final UINT16 kerningCount,
			final List<KerningRecord> fontKerningTable) {
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
		this.offsetTable = new ArrayList<IParsedINTElement>(offsetTable);
		this.glyphShapeTable = new ArrayList<Shape3>(glyphShapeTable);
		this.codeTable = new ArrayList<IParsedINTElement>(codeTable);
		this.fontAscent = fontAscent;
		this.fontDescent = fontDescent;
		this.fontLeading = fontLeading;
		this.fontAdvanceTable = new ArrayList<INT16>(fontAdvanceTable);
		this.fontBoundsTable = new ArrayList<Rect>(fontBoundsTable);
		this.kerningCount = kerningCount;
		this.fontKerningTable = new ArrayList<KerningRecord>(fontKerningTable);
	}

	/**
	 * Returns the glyph to code table.
	 * 
	 * @return The glyph to code table.
	 */
	public List<IParsedINTElement> getCodeTable() {
		return new ArrayList<IParsedINTElement>(codeTable
		);
	}

	/**
	 * Returns the advance values to be used for each glyph in dynamic glyph text.
	 * 
	 * @return The advance values to be used for each glyph in dynamic glyph text.
	 */
	public List<INT16> getFontAdvanceTable() {
		return new ArrayList<INT16>(fontAdvanceTable);
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
	public List<Rect> getFontBoundsTable() {
		return new ArrayList<Rect>(fontBoundsTable);
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
	public List<KerningRecord> getFontKerningTable() {
		return new ArrayList<KerningRecord>(fontKerningTable);
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
	public PString getFontName() {
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
	public ArrayList<Shape3> getGlyphShapeTable() {
		return new ArrayList<Shape3>(glyphShapeTable);
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
	 * Returns the array of shape offsets.
	 * 
	 * @return The array of shape offsets.
	 */
	public List<IParsedINTElement> getOffsetTable() {
		return new ArrayList<IParsedINTElement>(offsetTable);
	}
}