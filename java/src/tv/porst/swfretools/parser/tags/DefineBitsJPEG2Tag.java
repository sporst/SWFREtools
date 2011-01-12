package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.ByteArray;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineBitsJPEG2Tag extends Tag {

	public DefineBitsJPEG2Tag(final RecordHeader header, final UINT16 characterId,
			final ByteArray imageData) {
		super(header);
	}

}
