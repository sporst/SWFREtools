package tv.porst.swfretools.parser.tags;

import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineBitsJPEG3Tag extends Tag {

	public DefineBitsJPEG3Tag(final RecordHeader header, final int characterId,
			final byte[] jpegData, final byte[] bitmapAlphaData) {
		super(header);
	}

}
