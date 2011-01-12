package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT32;
import tv.porst.swfretools.parser.structures.ByteArray;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineBitsJPEG4Tag extends Tag {

	public DefineBitsJPEG4Tag(final RecordHeader header, final UINT16 characterId,
			final UINT32 alphaDataOffset, final UINT16 deblockParam, final ByteArray imageData,
			final ByteArray bitmapAlphaData) {
		super(header);
	}

}
