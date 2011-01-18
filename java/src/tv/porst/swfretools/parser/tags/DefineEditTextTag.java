package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.Flag;
import tv.porst.splib.io.INT16;
import tv.porst.splib.io.PString;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.structures.RGBA;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;

/**
 * Represents a DefineEditText tag.
 * 
 * @author sp
 *
 */
public final class DefineEditTextTag extends Tag {

	/**
	 * ID for this dynamic text character.
	 */
	private final UINT16 characterId;

	/**
	 * Rectangle that completely encloses the text field.
	 */
	private final Rect bounds;

	/**
	 * Default text flag.
	 */
	private final Flag hasText;

	/**
	 * Word wrap flag.
	 */
	private final Flag wordWrap;

	/**
	 * Multiline flag.
	 */
	private final Flag multiline;

	/**
	 * Password field flag.
	 */
	private final Flag password;

	/**
	 * Readonly flag.
	 */
	private final Flag readOnly;

	/**
	 * Text color flag.
	 */
	private final Flag hasTextColor;

	/**
	 * Maximum length flag.
	 */
	private final Flag hasMaxLength;

	/**
	 * Font information flag.
	 */
	private final Flag hasFont;

	/**
	 * Font class flag.
	 */
	private final Flag hasFontClass;

	/**
	 * Auto size flag.
	 */
	private final Flag autoSize;

	/**
	 * Layout flag.
	 */
	private final Flag hasLayout;

	/**
	 * Selection mode flag.
	 */
	private final Flag noSelect;

	/**
	 * Border flag.
	 */
	private final Flag border;

	/**
	 * Static text flag.
	 */
	private final Flag wasStatic;

	/**
	 * HTML formatting flag.
	 */
	private final Flag html;

	/**
	 * Outlines flag.
	 */
	private final Flag useOutlines;

	/**
	 * ID of font to use.
	 */
	private final UINT16 fontId;

	/**
	 * Class name of font to be loaded.
	 */
	private final PString fontClass;

	/**
	 * Height of font in twips.
	 */
	private final UINT16 fontHeight;

	/**
	 * Color of text.
	 */
	private final RGBA textColor;

	/**
	 * Maximum text length.
	 */
	private final UINT16 maxLength;

	/**
	 * Text alignment.
	 */
	private final UINT8 align;

	/**
	 * Left margin in twips.
	 */
	private final UINT16 leftMargin;

	/**
	 * Right margin in twips.
	 */
	private final UINT16 rightMargin;

	/**
	 * Indent in twips.
	 */
	private final UINT16 indent;

	/**
	 * Leading in twips.
	 */
	private final INT16 leading;

	/**
	 * Name of the variable where the contents of the text field are stored.
	 */
	private final PString variableName;

	/**
	 * Text that is initially displayed.
	 */
	private final PString initialText;

	/**
	 * Creates a new DefineEditText tag object.
	 * 
	 * @param header Tag header.
	 * @param characterId ID for this dynamic text character.
	 * @param bounds Rectangle that completely encloses the text field.
	 * @param hasText Default text flag.
	 * @param wordWrap Word wrap flag.
	 * @param multiline Multiline flag.
	 * @param password Password field flag.
	 * @param readOnly Readonly flag.
	 * @param hasTextColor Text color flag.
	 * @param hasMaxLength Maximum length flag.
	 * @param hasFont Font information flag.
	 * @param hasFontClass Font class flag.
	 * @param autoSize Auto size flag.
	 * @param hasLayout Layout flag.
	 * @param noSelect Selection mode flag.
	 * @param border Border flag.
	 * @param wasStatic Static text flag.
	 * @param html HTML formatting flag.
	 * @param useOutlines Outlines flag.
	 * @param fontId ID of font to use.
	 * @param fontClass Class name of font to be loaded.
	 * @param fontHeight Height of font in twips.
	 * @param textColor Color of text.
	 * @param maxLength Maximum text length.
	 * @param align Text alignment.
	 * @param leftMargin Left margin in twips.
	 * @param rightMargin Right margin in twips.
	 * @param indent Indent in twips.
	 * @param leading Leading in twips.
	 * @param variableName Name of the variable where the contents of the text field are stored.
	 * @param initialText Text that is initially displayed.
	 */
	public DefineEditTextTag(final RecordHeader header, final UINT16 characterId, final Rect bounds,
			final Flag hasText, final Flag wordWrap, final Flag multiline,
			final Flag password, final Flag readOnly, final Flag hasTextColor,
			final Flag hasMaxLength, final Flag hasFont, final Flag hasFontClass,
			final Flag autoSize, final Flag hasLayout, final Flag noSelect,
			final Flag border, final Flag wasStatic, final Flag html,
			final Flag useOutlines, final UINT16 fontId, final PString fontClass, final UINT16 fontHeight,
			final RGBA textColor, final UINT16 maxLength, final UINT8 align, final UINT16 leftMargin,
			final UINT16 rightMargin, final UINT16 indent, final INT16 leading, final PString variableName,
			final PString initialText) {

		super(header);

		this.characterId = characterId;
		this.bounds = bounds;
		this.hasText = hasText;
		this.wordWrap = wordWrap;
		this.multiline = multiline;
		this.password = password;
		this.readOnly = readOnly;
		this.hasTextColor = hasTextColor;
		this.hasMaxLength = hasMaxLength;
		this.hasFont = hasFont;
		this.hasFontClass = hasFontClass;
		this.autoSize = autoSize;
		this.hasLayout = hasLayout;
		this.noSelect = noSelect;
		this.border = border;
		this.wasStatic = wasStatic;
		this.html = html;
		this.useOutlines = useOutlines;
		this.fontId = fontId;
		this.fontClass = fontClass;
		this.fontHeight = fontHeight;
		this.textColor = textColor;
		this.maxLength = maxLength;
		this.align = align;
		this.leftMargin = leftMargin;
		this.rightMargin = rightMargin;
		this.indent = indent;
		this.leading = leading;
		this.variableName = variableName;
		this.initialText = initialText;
	}

	/**
	 * Returns the text alignment.
	 *
	 * @return The text alignment.
	 */
	public UINT8 getAlign() {
		return align;
	}

	/**
	 * Returns the auto size flag.
	 *
	 * @return The auto size flag.
	 */
	public Flag getAutoSize() {
		return autoSize;
	}

	/**
	 * Returns the border flag.
	 *
	 * @return The border flag.
	 */
	public Flag getBorder() {
		return border;
	}

	/**
	 * Returns the rectangle that completely encloses the text field.
	 *
	 * @return The rectangle that completely encloses the text field.
	 */
	public Rect getBounds() {
		return bounds;
	}

	/**
	 * Returns the ID for this dynamic text character.
	 *
	 * @return The ID for this dynamic text character.
	 */
	public UINT16 getCharacterId() {
		return characterId;
	}

	/**
	 * Returns the class name of font to be loaded.
	 *
	 * @return The class name of font to be loaded.
	 */
	public PString getFontClass() {
		return fontClass;
	}

	/**
	 * Returns the height of font in twips.
	 *
	 * @return The height of font in twips.
	 */
	public UINT16 getFontHeight() {
		return fontHeight;
	}

	/**
	 * Returns the ID of font to use.
	 *
	 * @return The ID of font to use.
	 */
	public UINT16 getFontId() {
		return fontId;
	}

	/**
	 * Returns the font information flag.
	 *
	 * @return The font information flag.
	 */
	public Flag getHasFont() {
		return hasFont;
	}

	/**
	 * Returns the font class flag.
	 *
	 * @return The font class flag.
	 */
	public Flag getHasFontClass() {
		return hasFontClass;
	}

	/**
	 * Returns the layout flag.
	 *
	 * @return The layout flag.
	 */
	public Flag getHasLayout() {
		return hasLayout;
	}

	/**
	 * Returns the maximum length flag.
	 *
	 * @return The maximum length flag.
	 */
	public Flag getHasMaxLength() {
		return hasMaxLength;
	}

	/**
	 * Returns the default text flag.
	 *
	 * @return The default text flag.
	 */
	public Flag getHasText() {
		return hasText;
	}

	/**
	 * Returns the text color flag.
	 *
	 * @return The text color flag.
	 */
	public Flag getHasTextColor() {
		return hasTextColor;
	}

	/**
	 * Returns the HTML formatting flag.
	 *
	 * @return The HTML formatting flag.
	 */
	public Flag getHtml() {
		return html;
	}

	/**
	 * Returns the indent in twips.
	 * 
	 * @return The indent in twips.
	 */
	public UINT16 getIndent() {
		return indent;
	}

	/**
	 * Returns the text that is initially displayed.
	 *
	 * @return The text that is initially displayed.
	 */
	public PString getInitialText() {
		return initialText;
	}

	/**
	 * Returns the leading in twips.
	 *
	 * @return The leading in twips.
	 */
	public INT16 getLeading() {
		return leading;
	}

	/**
	 * Returns the left margin in twips.
	 *
	 * @return The left margin in twips.
	 */
	public UINT16 getLeftMargin() {
		return leftMargin;
	}

	/**
	 * Returns the maximum text length.
	 *
	 * @return The maximum text length.
	 */
	public UINT16 getMaxLength() {
		return maxLength;
	}

	/**
	 * Returns the multiline flag.
	 *
	 * @return The multiline flag.
	 */
	public Flag getMultiline() {
		return multiline;
	}

	/**
	 * Returns the selection mode flag.
	 *
	 * @return The selection mode flag.
	 */
	public Flag getNoSelect() {
		return noSelect;
	}

	/**
	 * Returns the password field flag.
	 * 
	 * @return The password field flag.
	 */
	public Flag getPassword() {
		return password;
	}

	/**
	 * Returns the readonly flag.
	 *
	 * @return The readonly flag.
	 */
	public Flag getReadOnly() {
		return readOnly;
	}

	/**
	 * Returns the right margin in twips.
	 *
	 * @return The right margin in twips.
	 */
	public UINT16 getRightMargin() {
		return rightMargin;
	}

	/**
	 * Returns the color of text.
	 *
	 * @return The color of text.
	 */
	public RGBA getTextColor() {
		return textColor;
	}

	/**
	 * Returns the outlines flag.
	 *
	 * @return The outlines flag.
	 */
	public Flag getUseOutlines() {
		return useOutlines;
	}

	/**
	 * Returns the name of the variable where the contents of the text field are stored.
	 *
	 * @return The name of the variable where the contents of the text field are stored.
	 */
	public PString getVariableName() {
		return variableName;
	}

	/**
	 * Returns the static text flag.
	 *
	 * @return The static text flag.
	 */
	public Flag getWasStatic() {
		return wasStatic;
	}

	/**
	 * Returns the word wrap flag.
	 *
	 * @return The word wrap flag.
	 */
	public Flag getWordWrap() {
		return wordWrap;
	}
}