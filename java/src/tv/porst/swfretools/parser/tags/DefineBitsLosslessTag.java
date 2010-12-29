package tv.porst.swfretools.parser.tags;

import tv.porst.swfretools.parser.structures.BitmapData15;
import tv.porst.swfretools.parser.structures.ColormapData;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineBitsLosslessTag extends Tag {

	public DefineBitsLosslessTag(final RecordHeader header, final int characterId,
			final int bitmapFormat, final int bitmapWidth, final int bitmapHeight,
			final int bitmapColorTableSize, final ColormapData zlibColormapData,
			final BitmapData15 zlibBitmapData15, final BitmapData24 zlibBitmapData24) {
		super(header);
	}

}
