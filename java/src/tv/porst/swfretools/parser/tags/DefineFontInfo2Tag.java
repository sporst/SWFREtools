package tv.porst.swfretools.parser.tags;

import java.util.List;

import tv.porst.splib.io.Flag;
import tv.porst.splib.io.IParsedINTElement;
import tv.porst.splib.io.PString;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineFontInfo2Tag extends Tag {

	public DefineFontInfo2Tag(final RecordHeader header, final UINT16 fontId, final UINT8 fontNameLen,
			final PString fontName, final int fontFlagsReserved, final Flag fontFlagsSmallText,
			final Flag fontFlagsShiftJIS, final Flag fontFlagsANSI,
			final Flag fontFlagsItalic, final Flag fontFlagsBold,
			final Flag fontFlagsWideCodes, final UINT8 languageCode,
			final List<IParsedINTElement> codeTable) {
		super(header);
	}

}
