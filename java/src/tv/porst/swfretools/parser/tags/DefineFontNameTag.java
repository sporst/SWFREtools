package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a DefineFontName tag.
 */
public final class DefineFontNameTag extends Tag {

	/**
	 * ID for this font to which this refers.
	 */
	private final UINT16 fontId;

	/**
	 * Name of the font.
	 */
	private final AsciiString fontName;

	/**
	 * Arbitrary string of copyright information.
	 */
	private final AsciiString fontCopyright;

	/**
	 * Creates a new ShowFrame tag object.
	 * 
	 * @param header Tag header.
	 * @param fontId ID for this font to which this refers.
	 * @param fontName Name of the font.
	 * @param fontCopyright Arbitrary string of copyright information.
	 */
	public DefineFontNameTag(final RecordHeader header, final UINT16 fontId, final AsciiString fontName, final AsciiString fontCopyright) {
		super(header);

		this.fontId = fontId;
		this.fontName = fontName;
		this.fontCopyright = fontCopyright;
	}

	/**
	 * Returns the arbitrary string of copyright information.
	 * 
	 * @return The arbitrary string of copyright information.
	 */
	public AsciiString getFontCopyright() {
		return fontCopyright;
	}

	/**
	 * Returns the ID for this font to which this refers.
	 * 
	 * @return The ID for this font to which this refers.
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