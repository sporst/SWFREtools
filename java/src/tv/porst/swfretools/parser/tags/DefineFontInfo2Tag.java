package tv.porst.swfretools.parser.tags;

import java.util.List;

import tv.porst.splib.io.IParsedUINTElement;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineFontInfo2Tag extends Tag {

	public DefineFontInfo2Tag(final RecordHeader header, final UINT16 fontId, final UINT8 fontNameLen,
			final String fontName, final int fontFlagsReserved, final boolean fontFlagsSmallText,
			final boolean fontFlagsShiftJIS, final boolean fontFlagsANSI,
			final boolean fontFlagsItalic, final boolean fontFlagsBold,
			final boolean fontFlagsWideCodes, final UINT8 languageCode,
			final List<IParsedUINTElement> codeTable) {
		super(header);
	}

}
