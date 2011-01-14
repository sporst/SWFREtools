package tv.porst.swfretools.parser.structures;

import java.util.List;

import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.INT16;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;

public class TextRecord2 {

	public TextRecord2(final Flag textRecordType, final Bits styleFlagsReserved,
			final Flag styleFlagsHasFont, final Flag styleFlagsHasColor,
			final Flag styleFlagsHasYOffset, final Flag styleFlagsHasXOffset,
			final UINT16 fontID, final RGBA textColor, final INT16 xOffset, final INT16 yOffset,
			final UINT16 textHeight, final UINT8 glyphCount, final List<GlyphEntry> glyphEntries) {
		// TODO Auto-generated constructor stub
	}

}
