package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.Bits;
import tv.porst.splib.io.INT16;
import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class SoundStreamHead2Tag extends Tag {

	public SoundStreamHead2Tag(final RecordHeader header, final Bits reserved,
			final Bits playbackSoundRate, final Bits playbackSoundSize,
			final Bits playbackSoundType, final Bits streamSoundCompression,
			final Bits streamSoundRate, final Bits streamSoundSize, final Bits streamSoundType,
			final UINT16 streamSoundSampleCount, final INT16 latencySeek) {
		super(header);
	}

}
