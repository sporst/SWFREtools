package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseBits;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseINT16If;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import tv.porst.splib.io.Bits;
import tv.porst.splib.io.INT16;
import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Class for parsing SoundStreamHead2 tags.
 * 
 * @author sp
 */
public final class SoundStreamHead2Parser {

	/**
	 * Parses a SoundStreamHead2 tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static SoundStreamHead2Tag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final Bits reserved = parseBits(parser, 4, 0x00006, "SoundStreamHead2::Reserved");
		final Bits playbackSoundRate = parseBits(parser, 2, 0x00006, "SoundStreamHead2::PlaybackSoundRate");
		final Bits playbackSoundSize = parseBits(parser, 1, 0x00006, "SoundStreamHead2::PlaybackSoundSize");
		final Bits playbackSoundType = parseBits(parser, 1, 0x00006, "SoundStreamHead2::PlaybackSoundType");
		final Bits streamSoundCompression = parseBits(parser, 4, 0x00006, "SoundStreamHead2::StreamSoundCompression");
		final Bits streamSoundRate = parseBits(parser, 2, 0x00006, "SoundStreamHead2::StreamSoundRate");
		final Bits streamSoundSize = parseBits(parser, 1, 0x00006, "SoundStreamHead2::StreamSoundSize");
		final Bits streamSoundType = parseBits(parser, 1, 0x00006, "SoundStreamHead2::StreamSoundSize");
		final UINT16 streamSoundSampleCount = parseUINT16(parser, 0x00006, "SoundStreamHead2::StreamSoundSampleCount");
		final INT16 latencySeek = parseINT16If(parser, 0x00006, streamSoundCompression.value() == 2, "SoundStreamHead2::LatencySeek");

		return new SoundStreamHead2Tag(header, reserved, playbackSoundRate,
				playbackSoundSize, playbackSoundType, streamSoundCompression,
				streamSoundRate, streamSoundSize, streamSoundType,
				streamSoundSampleCount, latencySeek);
	}
}