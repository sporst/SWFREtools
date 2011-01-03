package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class SoundStreamHeadParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final int reserved = parser.readBits(4);
		final int playbackSoundRate = parser.readBits(2);
		final int playbackSoundSize = parser.readBits(1);
		final int playbackSoundType = parser.readBits(1);
		final int streamSoundCompression = parser.readBits(4);
		final int streamSoundRate = parser.readBits(2);
		final int streamSoundSize = parser.readBits(1);
		final int streamSoundType = parser.readBits(1);
		final UINT16 streamSoundSampleCount = parser.readUInt16();
		final int latencySeek = streamSoundCompression == 2 ? parser.readInt16() : 0;

		return new SoundStreamHeadTag(header, reserved, playbackSoundRate,
				playbackSoundSize, playbackSoundType, streamSoundCompression,
				streamSoundRate, streamSoundSize, streamSoundType,
				streamSoundSampleCount, latencySeek);
	}

}
