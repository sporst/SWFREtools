package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.Flag;
import tv.porst.splib.io.PString;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineFont4Tag extends Tag {

	public DefineFont4Tag(final RecordHeader header, final UINT8 fontID,
			final int fontFlagsReserved, final Flag fontFlagsItalic,
			final Flag fontFlagsBold, final PString fontName, final byte[] fontData) {
		super(header);
	}

}
