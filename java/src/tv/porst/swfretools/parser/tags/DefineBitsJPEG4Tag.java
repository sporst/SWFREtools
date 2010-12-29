package tv.porst.swfretools.parser.tags;

import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineBitsJPEG4Tag extends Tag {

	public DefineBitsJPEG4Tag(final RecordHeader header, final int characterId,
			final int alphaDataOffset, final int deblockParam, final byte[] imageData,
			final byte[] bitmapAlphaData) {
		super(header);
	}

}
