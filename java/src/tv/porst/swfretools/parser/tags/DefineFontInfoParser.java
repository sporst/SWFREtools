package tv.porst.swfretools.parser.tags;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.IParsedINTElement;
import tv.porst.splib.io.PString;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineFontInfoParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final UINT16 fontId = parser.readUInt16();
		final UINT8 fontNameLen = parser.readUInt8();
		final PString fontName = parser.readString(fontNameLen.value());
		final int fontFlagsReserved = parser.readBits(2);
		final Flag fontFlagsSmallText = parser.readFlag();
		final Flag fontFlagsShiftJIS = parser.readFlag();
		final Flag fontFlagsANSI = parser.readFlag();
		final Flag fontFlagsItalic = parser.readFlag();
		final Flag fontFlagsBold = parser.readFlag();
		final Flag fontFlagsWideCodes = parser.readFlag();

		final int remainingBytes = header.getNormalizedLength() - 2 - 1 - fontNameLen.value() - 1;

		final int numberOfGlyphs = remainingBytes / (fontFlagsWideCodes.value() ? 2 : 1);

		final List<IParsedINTElement> codeTable = new ArrayList<IParsedINTElement>();

		for (int i=0;i<numberOfGlyphs;i++) {
			if (fontFlagsWideCodes.value()) {
				codeTable.add(parser.readUInt16());
			}
			else {
				codeTable.add(parser.readUInt8());
			}
		}

		return new DefineFontInfoTag(header, fontId, fontNameLen, fontName,
				fontFlagsReserved, fontFlagsSmallText, fontFlagsShiftJIS,
				fontFlagsANSI, fontFlagsItalic, fontFlagsBold, fontFlagsWideCodes,
				codeTable);
	}

}
