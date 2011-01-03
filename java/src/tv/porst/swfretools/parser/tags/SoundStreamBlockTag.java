package tv.porst.swfretools.parser.tags;

import tv.porst.swfretools.parser.structures.RecordHeader;

public class SoundStreamBlockTag extends Tag {

	public SoundStreamBlockTag(final RecordHeader header, final byte[] streamSoundData) {
		super(header);
	}

}
