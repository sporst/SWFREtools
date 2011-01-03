package tv.porst.swfretools.parser.structures;

import java.util.List;

import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;

public class TextRecord {

	public TextRecord(final boolean textRecordType, final int styleFlagsReserved,
			final boolean styleFlagsHasFont, final boolean styleFlagsHasColor,
			final boolean styleFlagsHasYOffset, final boolean styleFlagsHasXOffset,
			final UINT16 fontID, final RGB textColor, final int xOffset, final int yOffset,
			final UINT16 textHeight, final UINT8 glyphCount, final List<GlyphEntry> glyphEntries) {
		// TODO Auto-generated constructor stub
	}

}
