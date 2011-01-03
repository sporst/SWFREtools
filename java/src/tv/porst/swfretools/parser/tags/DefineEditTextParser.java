package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.swfretools.parser.structures.RGBA;
import tv.porst.swfretools.parser.structures.RGBAParser;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.RectParser;

public class DefineEditTextParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final int characterID = parser.readUInt16();
		final Rect bounds = RectParser.parse(parser);
		final boolean hasText = parser.readFlag();
		final boolean wordWrap = parser.readFlag();
		final boolean multiline = parser.readFlag();
		final boolean password = parser.readFlag();
		final boolean readOnly = parser.readFlag();
		final boolean hasTextColor = parser.readFlag();
		final boolean hasMaxLength = parser.readFlag();
		final boolean hasFont = parser.readFlag();
		final boolean hasFontClass = parser.readFlag();
		final boolean autoSize = parser.readFlag();
		final boolean hasLayout = parser.readFlag();
		final boolean noSelect = parser.readFlag();
		final boolean border = parser.readFlag();
		final boolean wasStatic = parser.readFlag();
		final boolean html = parser.readFlag();
		final boolean useOutlines = parser.readFlag();
		final int fontID = hasFont ? parser.readUInt16() : 0;
		final String fontClass = hasFontClass ? parser.readString() : null;
		final int fontHeight = hasFont ? parser.readUInt16() : 0;
		final RGBA textColor = hasTextColor ? RGBAParser.parse(parser) : null;
		final int maxLength = hasMaxLength ? parser.readUInt16() : 0;
		final int align = hasLayout ? parser.readUInt8() : 0;
		final int leftMargin = hasLayout ? parser.readUInt16() : 0;
		final int rightMargin = hasLayout ? parser.readUInt16() : 0;
		final int indent = hasLayout ? parser.readUInt16() : 0;
		final int leading = hasLayout ? parser.readInt16() : 0;
		final String variableName = parser.readString();
		final String initialText = hasText ? parser.readString() : null;

		return new DefineEditTextTag(header, characterID, bounds, hasText, wordWrap,
				multiline, password, readOnly, hasTextColor, hasMaxLength, hasFont,
				hasFontClass, autoSize, hasLayout, noSelect, border, wasStatic, html,
				useOutlines, fontID, fontClass, fontHeight, textColor, maxLength, align,
				leftMargin, rightMargin, indent, leading, variableName, initialText);
	}

}
