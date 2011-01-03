package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.BinaryParser;

public class TextRecordParser {

	public static TextRecord parse(final BinaryParser parser, final int glyphBits, final int advanceBits) {
		final boolean textRecordType = parser.readFlag();
		final int styleFlagsReserved = parser.readBits(3);
		final boolean styleFlagsHasFont = parser.readFlag();
		final boolean styleFlagsHasColor = parser.readFlag();
		final boolean styleFlagsHasYOffset = parser.readFlag();
		final boolean styleFlagsHasXOffset = parser.readFlag();
		final int fontID = styleFlagsHasFont ? parser.readUInt16() : 0;
		final RGB textColor = styleFlagsHasColor ? RGBParser.parse(parser) : null;
		final int xOffset = styleFlagsHasXOffset ? parser.readInt16() : 0;
		final int yOffset = styleFlagsHasYOffset ? parser.readInt16() : 0;
		final int textHeight = styleFlagsHasFont ? parser.readUInt16() : 0;
		final int glyphCount = parser.readUInt8();

		final List<GlyphEntry> glyphEntries = new ArrayList<GlyphEntry>();

		for (int i=0;i<glyphCount;i++) {
			glyphEntries.add(GlyphEntryParser.parse(parser, glyphBits, advanceBits));
		}

		return new TextRecord(textRecordType, styleFlagsReserved, styleFlagsHasFont,
				styleFlagsHasColor, styleFlagsHasYOffset, styleFlagsHasXOffset,
				fontID, textColor, xOffset, yOffset, textHeight, glyphCount, glyphEntries);


	}

}
