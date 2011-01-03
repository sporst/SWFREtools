package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.INT16;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;

public class TextRecord2Parser {

	public static TextRecord2 parse(final BinaryParser parser, final int glyphBits,
			final int advanceBits) {
		final Flag textRecordType = parser.readFlag();
		final int styleFlagsReserved = parser.readBits(3);
		final Flag styleFlagsHasFont = parser.readFlag();
		final Flag styleFlagsHasColor = parser.readFlag();
		final Flag styleFlagsHasYOffset = parser.readFlag();
		final Flag styleFlagsHasXOffset = parser.readFlag();
		final UINT16 fontID = styleFlagsHasFont.value() ? parser.readUInt16() : null;
		final RGBA textColor = styleFlagsHasColor.value() ? RGBAParser.parse(parser) : null;
		final INT16 xOffset = styleFlagsHasXOffset.value() ? parser.readInt16() : null;
		final INT16 yOffset = styleFlagsHasYOffset.value() ? parser.readInt16() : null;
		final UINT16 textHeight = styleFlagsHasFont.value() ? parser.readUInt16() : null;
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
