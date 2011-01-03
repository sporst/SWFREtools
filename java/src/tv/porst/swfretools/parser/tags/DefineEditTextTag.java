package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.structures.RGBA;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;

public class DefineEditTextTag extends Tag {

	public DefineEditTextTag(final RecordHeader header, final UINT16 characterID, final Rect bounds,
			final boolean hasText, final boolean wordWrap, final boolean multiline,
			final boolean password, final boolean readOnly, final boolean hasTextColor,
			final boolean hasMaxLength, final boolean hasFont, final boolean hasFontClass,
			final boolean autoSize, final boolean hasLayout, final boolean noSelect,
			final boolean border, final boolean wasStatic, final boolean html,
			final boolean useOutlines, final UINT16 fontID, final String fontClass, final UINT16 fontHeight,
			final RGBA textColor, final UINT16 maxLength, final UINT8 align, final UINT16 leftMargin,
			final UINT16 rightMargin, final UINT16 indent, final int leading, final String variableName,
			final String initialText) {
		super(header);
	}

}
