package tv.porst.swfretools.parser.tags;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.IParsedUINTElement;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineFontInfo2Parser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final UINT16 fontId = parser.readUInt16();
		final UINT8 fontNameLen = parser.readUInt8();
		final String fontName = parser.readString(fontNameLen.value());
		final int fontFlagsReserved = parser.readBits(2);
		final boolean fontFlagsSmallText = parser.readFlag();
		final boolean fontFlagsShiftJIS = parser.readFlag();
		final boolean fontFlagsANSI = parser.readFlag();
		final boolean fontFlagsItalic = parser.readFlag();
		final boolean fontFlagsBold = parser.readFlag();
		final boolean fontFlagsWideCodes = parser.readFlag();
		final UINT8 languageCode = parser.readUInt8();

		final int remainingBytes = header.getNormalizedLength() - 2 - 1 - fontNameLen.value() - 1 - 1;

		final int numberOfGlyphs = remainingBytes / (fontFlagsWideCodes ? 2 : 1);

		final List<IParsedUINTElement> codeTable = new ArrayList<IParsedUINTElement>();

		for (int i=0;i<numberOfGlyphs;i++) {
			if (fontFlagsWideCodes) {
				codeTable.add(parser.readUInt16());
			}
			else {
				codeTable.add(parser.readUInt8());
			}
		}

		return new DefineFontInfo2Tag(header, fontId, fontNameLen, fontName,
				fontFlagsReserved, fontFlagsSmallText, fontFlagsShiftJIS,
				fontFlagsANSI, fontFlagsItalic, fontFlagsBold, fontFlagsWideCodes, languageCode, codeTable);
	}

}
