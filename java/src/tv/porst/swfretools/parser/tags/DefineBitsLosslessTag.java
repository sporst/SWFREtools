package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.structures.BitmapData15;
import tv.porst.swfretools.parser.structures.ColormapData;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineBitsLosslessTag extends Tag {

	public DefineBitsLosslessTag(final RecordHeader header, final UINT16 characterId,
			final UINT8 bitmapFormat, final UINT16 bitmapWidth, final UINT16 bitmapHeight,
			final UINT8 bitmapColorTableSize, final ColormapData zlibColormapData,
			final BitmapData15 zlibBitmapData15, final BitmapData24 zlibBitmapData24) {
		super(header);
	}

}
