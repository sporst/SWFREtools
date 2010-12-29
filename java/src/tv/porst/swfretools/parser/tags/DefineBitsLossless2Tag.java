package tv.porst.swfretools.parser.tags;

import tv.porst.swfretools.parser.structures.AlphaBitmapData;
import tv.porst.swfretools.parser.structures.AlphaColormapData;
import tv.porst.swfretools.parser.structures.RecordHeader;


public class DefineBitsLossless2Tag extends Tag {

	public DefineBitsLossless2Tag(final RecordHeader header, final int characterId,
			final int bitmapFormat, final int bitmapWidth, final int bitmapHeight,
			final int bitmapColorTableSize, final AlphaColormapData zlibColormapData,
			final AlphaBitmapData zlibBitmapData) {
		super(header);
	}

}
