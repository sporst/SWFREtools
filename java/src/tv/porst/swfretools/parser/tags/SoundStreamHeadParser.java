package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseBits;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseINT16If;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import tv.porst.splib.io.INT16;
import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Class for parsing SoundStreamHead tags.
 * 
 * @author sp
 */
public final class SoundStreamHeadParser {

	/**
	 * Parses a SoundStreamHead tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static SoundStreamHeadTag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final int reserved = parseBits(parser, 4, 0x00006, "SoundStreamHead::Reserved");
		final int playbackSoundRate = parseBits(parser, 2, 0x00006, "SoundStreamHead::PlaybackSoundRate");
		final int playbackSoundSize = parseBits(parser, 1, 0x00006, "SoundStreamHead::PlaybackSoundSize");
		final int playbackSoundType = parseBits(parser, 1, 0x00006, "SoundStreamHead::PlaybackSoundType");
		final int streamSoundCompression = parseBits(parser, 4, 0x00006, "SoundStreamHead::StreamSoundCompression");
		final int streamSoundRate = parseBits(parser, 2, 0x00006, "SoundStreamHead::StreamSoundRate");
		final int streamSoundSize = parseBits(parser, 1, 0x00006, "SoundStreamHead::StreamSoundSize");
		final int streamSoundType = parseBits(parser, 1, 0x00006, "SoundStreamHead::StreamSoundSize");
		final UINT16 streamSoundSampleCount = parseUINT16(parser, 0x00006, "SoundStreamHead::StreamSoundSampleCount");
		final INT16 latencySeek = parseINT16If(parser, 0x00006, streamSoundCompression == 2, "SoundStreamHead::LatencySeek");

		return new SoundStreamHeadTag(header, reserved, playbackSoundRate,
				playbackSoundSize, playbackSoundType, streamSoundCompression,
				streamSoundRate, streamSoundSize, streamSoundType,
				streamSoundSampleCount, latencySeek);
	}
}