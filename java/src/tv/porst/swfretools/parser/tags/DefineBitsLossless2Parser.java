package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.structures.AlphaBitmapData;
import tv.porst.swfretools.parser.structures.AlphaBitmapDataParser;
import tv.porst.swfretools.parser.structures.AlphaColormapData;
import tv.porst.swfretools.parser.structures.AlphaColormapDataParser;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineBitsLossless2Parser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final UINT16 characterId = parser.readUInt16();
		final UINT8 bitmapFormat = parser.readUInt8();
		final UINT16 bitmapWidth = parser.readUInt16();
		final UINT16 bitmapHeight = parser.readUInt16();
		final UINT8 bitmapColorTableSize = bitmapFormat.value() == 3 ? parser.readUInt8() : null;
		final AlphaColormapData zlibColormapData = bitmapFormat.value() == 3 ? AlphaColormapDataParser.parse(parser, bitmapColorTableSize.value(), header.getNormalizedLength() - bitmapColorTableSize.value()) : null;
		final AlphaBitmapData zlibBitmapData = bitmapFormat.value() == 4 || bitmapFormat.value() == 5 ? AlphaBitmapDataParser.parse(parser, header.getNormalizedLength()) : null;

		return new DefineBitsLossless2Tag(header, characterId, bitmapFormat, bitmapWidth, bitmapHeight, bitmapColorTableSize, zlibColormapData, zlibBitmapData);
	}

}
