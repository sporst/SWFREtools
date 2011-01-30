package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlag;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseINT16If;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseString;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseStringIf;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16If;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8If;
import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.INT16;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.RGBA;
import tv.porst.swfretools.parser.structures.RGBAParser;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.RectParser;

/**
 * Class for parsing DefineEditText tags.
 * 
 * @author sp
 */
public final class DefineEditTextParser {

	/**
	 * Parses a DefineEditText tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static DefineEditTextTag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final UINT16 characterId = parseUINT16(parser, 0x00006, "DefineEditText::CharacterId");
		final Rect bounds = RectParser.parse(parser, "DefineEditText::Bounds");
		final Flag hasText = parseFlag(parser, 0x00006, "DefineEditText::HasText");
		final Flag wordWrap = parseFlag(parser, 0x00006, "DefineEditText::WordWrap");
		final Flag multiline = parseFlag(parser, 0x00006, "DefineEditText::Multiline");
		final Flag password = parseFlag(parser, 0x00006, "DefineEditText::Password");
		final Flag readOnly = parseFlag(parser, 0x00006, "DefineEditText::ReadOnly");
		final Flag hasTextColor = parseFlag(parser, 0x00006, "DefineEditText::HasTextColor");
		final Flag hasMaxLength = parseFlag(parser, 0x00006, "DefineEditText::HasMaxLength");
		final Flag hasFont = parseFlag(parser, 0x00006, "DefineEditText::HasFont");
		final Flag hasFontClass = parseFlag(parser, 0x00006, "DefineEditText::HasFontClass");
		final Flag autoSize = parseFlag(parser, 0x00006, "DefineEditText::HasAutoSize");
		final Flag hasLayout = parseFlag(parser, 0x00006, "DefineEditText::HasLayout");
		final Flag noSelect = parseFlag(parser, 0x00006, "DefineEditText::NoSelect");
		final Flag border = parseFlag(parser, 0x00006, "DefineEditText::Border");
		final Flag wasStatic = parseFlag(parser, 0x00006, "DefineEditText::WasStatic");
		final Flag html = parseFlag(parser, 0x00006, "DefineEditText::HTML");
		final Flag useOutlines = parseFlag(parser, 0x00006, "DefineEditText::UseOutlines");
		final UINT16 fontID = parseUINT16If(parser, 0x00006, hasFont, "DefineEditText::FontID");
		final AsciiString fontClass = parseStringIf(parser, 0x00006, hasFontClass, "DefineEditText::FontClass");
		final UINT16 fontHeight = parseUINT16If(parser, 0x00006, hasFont, "DefineEditText::FontHeight");
		final RGBA textColor = RGBAParser.parseIf(parser, hasTextColor, "DefineEditText::TextColor");
		final UINT16 maxLength = parseUINT16If(parser, 0x00006, hasMaxLength, "DefineEditText::MaxLength");
		final UINT8 align = parseUINT8If(parser, 0x00006, hasLayout, "DefineEditText::Align");
		final UINT16 leftMargin = parseUINT16If(parser, 0x00006, hasLayout, "DefineEditText::LeftMargin");
		final UINT16 rightMargin = parseUINT16If(parser, 0x00006, hasLayout, "DefineEditText::RightMargin");
		final UINT16 indent = parseUINT16If(parser, 0x00006, hasLayout, "DefineEditText::Indent");
		final INT16 leading = parseINT16If(parser, 0x00006, hasLayout, "DefineEditText::Leading");
		final AsciiString variableName = parseString(parser, 0x00006, "DefineEditText::VariableName");
		final AsciiString initialText = parseStringIf(parser, 0x00006, hasText, "DefineEditText::InitialText");

		return new DefineEditTextTag(header, characterId, bounds, hasText, wordWrap,
				multiline, password, readOnly, hasTextColor, hasMaxLength, hasFont,
				hasFontClass, autoSize, hasLayout, noSelect, border, wasStatic, html,
				useOutlines, fontID, fontClass, fontHeight, textColor, maxLength, align,
				leftMargin, rightMargin, indent, leading, variableName, initialText);
	}
}