package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.swfretools.parser.structures.BitmapData15;
import tv.porst.swfretools.parser.structures.BitmapData15Parser;
import tv.porst.swfretools.parser.structures.ColormapData;
import tv.porst.swfretools.parser.structures.ColormapDataParser;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineBitsLosslessParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final int characterId = parser.readUInt16();
		final int bitmapFormat = parser.readUInt8();
		final int bitmapWidth = parser.readUInt16();
		final int bitmapHeight = parser.readUInt16();
		final int bitmapColorTableSize = bitmapFormat == 3 ? parser.readUInt8() : 0;
		final ColormapData zlibColormapData = bitmapFormat == 3 ? ColormapDataParser.parse(parser, bitmapColorTableSize, header.getNormalizedLength() - bitmapColorTableSize) : null;
		final BitmapData15 zlibBitmapData15 = bitmapFormat == 4 ? BitmapData15Parser.parse(parser, header.getNormalizedLength()) : null;
		final BitmapData24 zlibBitmapData24 = bitmapFormat == 5 ? BitmapData24Parser.parse(parser, header.getNormalizedLength()) : null;

		return new DefineBitsLosslessTag(header, characterId, bitmapFormat, bitmapWidth, bitmapHeight, bitmapColorTableSize, zlibColormapData, zlibBitmapData15, zlibBitmapData24);
	}

}
