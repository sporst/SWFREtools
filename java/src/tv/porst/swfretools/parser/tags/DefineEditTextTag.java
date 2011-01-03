package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.Flag;
import tv.porst.splib.io.INT16;
import tv.porst.splib.io.PString;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.structures.RGBA;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;

public class DefineEditTextTag extends Tag {

	public DefineEditTextTag(final RecordHeader header, final UINT16 characterID, final Rect bounds,
			final Flag hasText, final Flag wordWrap, final Flag multiline,
			final Flag password, final Flag readOnly, final Flag hasTextColor,
			final Flag hasMaxLength, final Flag hasFont, final Flag hasFontClass,
			final Flag autoSize, final Flag hasLayout, final Flag noSelect,
			final Flag border, final Flag wasStatic, final Flag html,
			final Flag useOutlines, final UINT16 fontID, final PString fontClass, final UINT16 fontHeight,
			final RGBA textColor, final UINT16 maxLength, final UINT8 align, final UINT16 leftMargin,
			final UINT16 rightMargin, final UINT16 indent, final INT16 leading, final PString variableName,
			final PString initialText) {
		super(header);
	}

}
