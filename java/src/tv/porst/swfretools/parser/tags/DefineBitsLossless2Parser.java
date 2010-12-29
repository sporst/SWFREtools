package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.swfretools.parser.structures.AlphaBitmapData;
import tv.porst.swfretools.parser.structures.AlphaBitmapDataParser;
import tv.porst.swfretools.parser.structures.AlphaColormapData;
import tv.porst.swfretools.parser.structures.AlphaColormapDataParser;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineBitsLossless2Parser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final int characterId = parser.readUInt16();
		final int bitmapFormat = parser.readUInt8();
		final int bitmapWidth = parser.readUInt16();
		final int bitmapHeight = parser.readUInt16();
		final int bitmapColorTableSize = bitmapFormat == 3 ? parser.readUInt8() : 0;
		final AlphaColormapData zlibColormapData = bitmapFormat == 3 ? AlphaColormapDataParser.parse(parser, bitmapColorTableSize, header.getNormalizedLength() - bitmapColorTableSize) : null;
		final AlphaBitmapData zlibBitmapData = bitmapFormat == 4 || bitmapFormat == 5 ? AlphaBitmapDataParser.parse(parser, header.getNormalizedLength()) : null;

		return new DefineBitsLossless2Tag(header, characterId, bitmapFormat, bitmapWidth, bitmapHeight, bitmapColorTableSize, zlibColormapData, zlibBitmapData);
	}

}
