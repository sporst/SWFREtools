package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.ByteArray;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineBitsJPEG3Tag extends Tag {

	public DefineBitsJPEG3Tag(final RecordHeader header, final UINT16 characterId,
			final ByteArray jpegData, final ByteArray bitmapAlphaData) {
		super(header);
	}

}
