package tv.porst.swfretools.parser.tags;

import tv.porst.swfretools.parser.structures.RGBA;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;

public class DefineEditTextTag extends Tag {

	public DefineEditTextTag(final RecordHeader header, final int characterID, final Rect bounds,
			final boolean hasText, final boolean wordWrap, final boolean multiline,
			final boolean password, final boolean readOnly, final boolean hasTextColor,
			final boolean hasMaxLength, final boolean hasFont, final boolean hasFontClass,
			final boolean autoSize, final boolean hasLayout, final boolean noSelect,
			final boolean border, final boolean wasStatic, final boolean html,
			final boolean useOutlines, final int fontID, final String fontClass, final int fontHeight,
			final RGBA textColor, final int maxLength, final int align, final int leftMargin,
			final int rightMargin, final int indent, final int leading, final String variableName,
			final String initialText) {
		super(header);
	}

}
