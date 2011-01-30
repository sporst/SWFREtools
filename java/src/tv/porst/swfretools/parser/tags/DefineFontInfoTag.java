package tv.porst.swfretools.parser.tags;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.IParsedINTElement;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a DefineFontInfo tag.
 * 
 * @author sp
 *
 */
public final class DefineFontInfoTag extends Tag {

	/**
	 * Font ID this information is for.
	 */
	private final UINT16 fontId;

	/**
	 * Length of font name.
	 */
	private final UINT8 fontNameLen;

	/**
	 * Name of the font.
	 */
	private final AsciiString fontName;

	/**
	 * Reserved bit fields.
	 */
	private final UBits fontFlagsReserved;

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
	 * Glyph to code table.
	 */
	private final List<IParsedINTElement> codeTable;

	/**
	 * Creates a new DefineFontInfo tag object.
	 * 
	 * @param header Tag header.
	 * @param fontId Font ID this information is for.
	 * @param fontNameLen Length of font name.
	 * @param fontName Name of the font.
	 * @param fontFlagsReserved Reserved bit fields.
	 * @param fontFlagsSmallText Font is small flag.
	 * @param fontFlagsShiftJIS ShiftJIS character codes flag.
	 * @param fontFlagsANSI ANSI character code flags.
	 * @param fontFlagsItalic Italic font flag.
	 * @param fontFlagsBold Bold font flag.
	 * @param fontFlagsWideCodes Wide codes flag.
	 * @param codeTable Glyph to code table.
	 */
	public DefineFontInfoTag(final RecordHeader header, final UINT16 fontId, final UINT8 fontNameLen,
			final AsciiString fontName, final UBits fontFlagsReserved, final Flag fontFlagsSmallText,
			final Flag fontFlagsShiftJIS, final Flag fontFlagsANSI,
			final Flag fontFlagsItalic, final Flag fontFlagsBold,
			final Flag fontFlagsWideCodes, final List<IParsedINTElement> codeTable) {

		super(header);

		this.fontId = fontId;
		this.fontNameLen = fontNameLen;
		this.fontName = fontName;
		this.fontFlagsReserved = fontFlagsReserved;
		this.fontFlagsSmallText = fontFlagsSmallText;
		this.fontFlagsShiftJIS = fontFlagsShiftJIS;
		this.fontFlagsANSI = fontFlagsANSI;
		this.fontFlagsItalic = fontFlagsItalic;
		this.fontFlagsBold = fontFlagsBold;
		this.fontFlagsWideCodes = fontFlagsWideCodes;
		this.codeTable = new ArrayList<IParsedINTElement>(codeTable);
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
	 * Returns the font ID this information is for.
	 * 
	 * @return The font ID this information is for.
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

	/**
	 * Returns the length of font name.
	 * 
	 * @return The length of font name.
	 */
	public UINT8 getFontNameLen() {
		return fontNameLen;
	}
}