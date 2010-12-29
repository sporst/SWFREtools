package tv.porst.swfretools.parser.tags;

import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineBitsJPEG2Tag extends Tag {

	public DefineBitsJPEG2Tag(final RecordHeader header, final int characterId,
			final byte[] imageData) {
		super(header);
	}

}
