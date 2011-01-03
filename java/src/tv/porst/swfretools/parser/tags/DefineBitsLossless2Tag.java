package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.structures.AlphaBitmapData;
import tv.porst.swfretools.parser.structures.AlphaColormapData;
import tv.porst.swfretools.parser.structures.RecordHeader;


public class DefineBitsLossless2Tag extends Tag {

	public DefineBitsLossless2Tag(final RecordHeader header, final UINT16 characterId,
			final UINT8 bitmapFormat, final UINT16 bitmapWidth, final UINT16 bitmapHeight,
			final UINT8 bitmapColorTableSize, final AlphaColormapData zlibColormapData,
			final AlphaBitmapData zlibBitmapData) {
		super(header);
	}

}
