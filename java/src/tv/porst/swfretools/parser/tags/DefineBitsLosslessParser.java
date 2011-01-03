package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.structures.BitmapData15;
import tv.porst.swfretools.parser.structures.BitmapData15Parser;
import tv.porst.swfretools.parser.structures.ColormapData;
import tv.porst.swfretools.parser.structures.ColormapDataParser;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineBitsLosslessParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final UINT16 characterId = parser.readUInt16();
		final UINT8 bitmapFormat = parser.readUInt8();
		final UINT16 bitmapWidth = parser.readUInt16();
		final UINT16 bitmapHeight = parser.readUInt16();

		final int bitmapFormatValue = bitmapFormat.value();

		final UINT8 bitmapColorTableSize = bitmapFormatValue == 3 ? parser.readUInt8() : null;
		final ColormapData zlibColormapData = bitmapFormatValue == 3 ? ColormapDataParser.parse(parser, bitmapColorTableSize.value(), header.getNormalizedLength() - bitmapColorTableSize.value()) : null;
		final BitmapData15 zlibBitmapData15 = bitmapFormatValue == 4 ? BitmapData15Parser.parse(parser, header.getNormalizedLength()) : null;
		final BitmapData24 zlibBitmapData24 = bitmapFormatValue == 5 ? BitmapData24Parser.parse(parser, header.getNormalizedLength()) : null;

		return new DefineBitsLosslessTag(header, characterId, bitmapFormat, bitmapWidth, bitmapHeight, bitmapColorTableSize, zlibColormapData, zlibBitmapData15, zlibBitmapData24);
	}

}
