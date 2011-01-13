package tv.porst.swfretools.parser.tags;

import tv.porst.swfretools.parser.structures.ByteArray;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class SoundStreamBlockTag extends Tag {

	public SoundStreamBlockTag(final RecordHeader header, final ByteArray streamSoundData) {
		super(header);
	}

}
