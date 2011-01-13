package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.Flag;
import tv.porst.splib.io.PString;
import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.ByteArray;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineFont4Tag extends Tag {

	public DefineFont4Tag(final RecordHeader header, final UINT16 fontId,
			final int fontFlagsReserved, final Flag fontFlagsItalic,
			final Flag fontFlagsBold, final PString fontName, final ByteArray fontData) {
		super(header);
	}

}
