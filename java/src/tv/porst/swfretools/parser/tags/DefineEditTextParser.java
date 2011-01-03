package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.INT16;
import tv.porst.splib.io.PString;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.structures.RGBA;
import tv.porst.swfretools.parser.structures.RGBAParser;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.RectParser;

public class DefineEditTextParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final UINT16 characterID = parser.readUInt16();
		final Rect bounds = RectParser.parse(parser);
		final Flag hasText = parser.readFlag();
		final Flag wordWrap = parser.readFlag();
		final Flag multiline = parser.readFlag();
		final Flag password = parser.readFlag();
		final Flag readOnly = parser.readFlag();
		final Flag hasTextColor = parser.readFlag();
		final Flag hasMaxLength = parser.readFlag();
		final Flag hasFont = parser.readFlag();
		final Flag hasFontClass = parser.readFlag();
		final Flag autoSize = parser.readFlag();
		final Flag hasLayout = parser.readFlag();
		final Flag noSelect = parser.readFlag();
		final Flag border = parser.readFlag();
		final Flag wasStatic = parser.readFlag();
		final Flag html = parser.readFlag();
		final Flag useOutlines = parser.readFlag();
		final UINT16 fontID = hasFont.value() ? parser.readUInt16() : null;
		final PString fontClass = hasFontClass.value() ? parser.readString() : null;
		final UINT16 fontHeight = hasFont.value() ? parser.readUInt16() : null;
		final RGBA textColor = hasTextColor.value() ? RGBAParser.parse(parser) : null;
		final UINT16 maxLength = hasMaxLength.value() ? parser.readUInt16() : null;
		final UINT8 align = hasLayout.value() ? parser.readUInt8() : null;
		final UINT16 leftMargin = hasLayout.value() ? parser.readUInt16() : null;
		final UINT16 rightMargin = hasLayout.value() ? parser.readUInt16() : null;
		final UINT16 indent = hasLayout.value() ? parser.readUInt16() : null;
		final INT16 leading = hasLayout.value() ? parser.readInt16() : null;
		final PString variableName = parser.readString();
		final PString initialText = hasText.value() ? parser.readString() : null;

		return new DefineEditTextTag(header, characterID, bounds, hasText, wordWrap,
				multiline, password, readOnly, hasTextColor, hasMaxLength, hasFont,
				hasFontClass, autoSize, hasLayout, noSelect, border, wasStatic, html,
				useOutlines, fontID, fontClass, fontHeight, textColor, maxLength, align,
				leftMargin, rightMargin, indent, leading, variableName, initialText);
	}

}
