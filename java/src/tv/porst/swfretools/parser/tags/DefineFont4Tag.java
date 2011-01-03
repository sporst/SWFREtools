package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineFont4Tag extends Tag {

	public DefineFont4Tag(final RecordHeader header, final UINT8 fontID,
			final int fontFlagsReserved, final boolean fontFlagsItalic,
			final boolean fontFlagsBold, final String fontName, final byte[] fontData) {
		super(header);
	}

}
