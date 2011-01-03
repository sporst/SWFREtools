package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;

public class TextRecord2Parser {

	public static TextRecord2 parse(final BinaryParser parser, final int glyphBits,
			final int advanceBits) {
		final boolean textRecordType = parser.readFlag();
		final int styleFlagsReserved = parser.readBits(3);
		final boolean styleFlagsHasFont = parser.readFlag();
		final boolean styleFlagsHasColor = parser.readFlag();
		final boolean styleFlagsHasYOffset = parser.readFlag();
		final boolean styleFlagsHasXOffset = parser.readFlag();
		final UINT16 fontID = styleFlagsHasFont ? parser.readUInt16() : null;
		final RGBA textColor = styleFlagsHasColor ? RGBAParser.parse(parser) : null;
		final int xOffset = styleFlagsHasXOffset ? parser.readInt16() : 0;
		final int yOffset = styleFlagsHasYOffset ? parser.readInt16() : 0;
		final UINT16 textHeight = styleFlagsHasFont ? parser.readUInt16() : null;
		final UINT8 glyphCount = parser.readUInt8();

		final List<GlyphEntry> glyphEntries = new ArrayList<GlyphEntry>();

		for (int i=0;i<glyphCount.value();i++) {
			glyphEntries.add(GlyphEntryParser.parse(parser, glyphBits, advanceBits));
		}

		return new TextRecord2(textRecordType, styleFlagsReserved, styleFlagsHasFont,
				styleFlagsHasColor, styleFlagsHasYOffset, styleFlagsHasXOffset,
				fontID, textColor, xOffset, yOffset, textHeight, glyphCount, glyphEntries);


	}

}
