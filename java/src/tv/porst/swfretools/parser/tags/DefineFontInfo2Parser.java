package tv.porst.swfretools.parser.tags;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.BinaryParser;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineFontInfo2Parser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final int fontId = parser.readUInt16();
		final int fontNameLen = parser.readUInt8();
		final String fontName = parser.readString(fontNameLen);
		final int fontFlagsReserved = parser.readBits(2);
		final boolean fontFlagsSmallText = parser.readFlag();
		final boolean fontFlagsShiftJIS = parser.readFlag();
		final boolean fontFlagsANSI = parser.readFlag();
		final boolean fontFlagsItalic = parser.readFlag();
		final boolean fontFlagsBold = parser.readFlag();
		final boolean fontFlagsWideCodes = parser.readFlag();
		final int languageCode = parser.readUInt8();

		final int remainingBytes = header.getNormalizedLength() - 2 - 1 - fontNameLen - 1 - 1;

		final int numberOfGlyphs = remainingBytes / (fontFlagsWideCodes ? 2 : 1);

		final List<Integer> codeTable = new ArrayList<Integer>();

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
