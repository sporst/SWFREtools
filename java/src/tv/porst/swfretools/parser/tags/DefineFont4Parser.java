package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.BinaryParserHelpers;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineFont4Parser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final int fontID = parser.readUInt8();
		final int fontFlagsReserved = parser.readBits(5);
		final boolean fontFlagsHasFontData = parser.readFlag();
		final boolean fontFlagsItalic = parser.readFlag();
		final boolean fontFlagsBold = parser.readFlag();
		final String fontName = parser.readString();

		final int remainingLength = header.getNormalizedLength() - 1 - 1 - fontName.length() - 1;

		final byte[] fontData = fontFlagsHasFontData ? BinaryParserHelpers.readByteArray(parser, remainingLength) : null;

		return new DefineFont4Tag(header, fontID, fontFlagsReserved, fontFlagsItalic, fontFlagsBold, fontName, fontData);
	}

}
