package tv.porst.swfretools.parser.tags;

import tv.porst.swfretools.parser.structures.RecordHeader;

public class SoundStreamHeadTag extends Tag {

	public SoundStreamHeadTag(final RecordHeader header, final int reserved,
			final int playbackSoundRate, final int playbackSoundSize,
			final int playbackSoundType, final int streamSoundCompression,
			final int streamSoundRate, final int streamSoundSize, final int streamSoundType,
			final int streamSoundSampleCount, final int latencySeek) {
		super(header);
	}

}
