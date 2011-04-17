package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseINT16If;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUBits;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import tv.porst.splib.binaryparser.INT16;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Class for parsing SoundStreamHead tags.
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

		final UBits reserved = parseUBits(parser, 4, 0x00006, "SoundStreamHead::Reserved");
		final UBits playbackSoundRate = parseUBits(parser, 2, 0x00006, "SoundStreamHead::PlaybackSoundRate");
		final UBits playbackSoundSize = parseUBits(parser, 1, 0x00006, "SoundStreamHead::PlaybackSoundSize");
		final UBits playbackSoundType = parseUBits(parser, 1, 0x00006, "SoundStreamHead::PlaybackSoundType");
		final UBits streamSoundCompression = parseUBits(parser, 4, 0x00006, "SoundStreamHead::StreamSoundCompression");
		final UBits streamSoundRate = parseUBits(parser, 2, 0x00006, "SoundStreamHead::StreamSoundRate");
		final UBits streamSoundSize = parseUBits(parser, 1, 0x00006, "SoundStreamHead::StreamSoundSize");
		final UBits streamSoundType = parseUBits(parser, 1, 0x00006, "SoundStreamHead::StreamSoundSize");
		final UINT16 streamSoundSampleCount = parseUINT16(parser, 0x00006, "SoundStreamHead::StreamSoundSampleCount");
		final INT16 latencySeek = parseINT16If(parser, 0x00006, streamSoundCompression.value() == 2, "SoundStreamHead::LatencySeek");

		return new SoundStreamHeadTag(header, reserved, playbackSoundRate,
				playbackSoundSize, playbackSoundType, streamSoundCompression,
				streamSoundRate, streamSoundSize, streamSoundType,
				streamSoundSampleCount, latencySeek);
	}
}