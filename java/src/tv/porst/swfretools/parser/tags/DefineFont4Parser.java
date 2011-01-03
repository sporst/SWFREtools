package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.BinaryParserHelpers;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.PString;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineFont4Parser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final UINT8 fontID = parser.readUInt8();
		final int fontFlagsReserved = parser.readBits(5);
		final Flag fontFlagsHasFontData = parser.readFlag();
		final Flag fontFlagsItalic = parser.readFlag();
		final Flag fontFlagsBold = parser.readFlag();
		final PString fontName = parser.readString();

		final int remainingLength = header.getNormalizedLength() - 1 - 1 - fontName.value().length() - 1;

		final byte[] fontData = fontFlagsHasFontData.value() ? BinaryParserHelpers.readByteArray(parser, remainingLength) : null;

		return new DefineFont4Tag(header, fontID, fontFlagsReserved, fontFlagsItalic, fontFlagsBold, fontName, fontData);
	}

}
