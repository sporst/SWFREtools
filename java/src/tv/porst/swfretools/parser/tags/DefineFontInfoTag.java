package tv.porst.swfretools.parser.tags;

import java.util.List;

import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.IParsedINTElement;
import tv.porst.splib.io.PString;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineFontInfoTag extends Tag {

	public DefineFontInfoTag(final RecordHeader header, final UINT16 fontId, final UINT8 fontNameLen,
			final PString fontName, final Bits fontFlagsReserved, final Flag fontFlagsSmallText,
			final Flag fontFlagsShiftJIS, final Flag fontFlagsANSI,
			final Flag fontFlagsItalic, final Flag fontFlagsBold,
			final Flag fontFlagsWideCodes, final List<IParsedINTElement> codeTable) {
		super(header);
	}

}
