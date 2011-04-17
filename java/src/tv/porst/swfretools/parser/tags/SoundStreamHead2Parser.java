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
 * Class for parsing SoundStreamHead2 tags.
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

		final UBits reserved = parseUBits(parser, 4, 0x00006, "SoundStreamHead2::Reserved");
		final UBits playbackSoundRate = parseUBits(parser, 2, 0x00006, "SoundStreamHead2::PlaybackSoundRate");
		final UBits playbackSoundSize = parseUBits(parser, 1, 0x00006, "SoundStreamHead2::PlaybackSoundSize");
		final UBits playbackSoundType = parseUBits(parser, 1, 0x00006, "SoundStreamHead2::PlaybackSoundType");
		final UBits streamSoundCompression = parseUBits(parser, 4, 0x00006, "SoundStreamHead2::StreamSoundCompression");
		final UBits streamSoundRate = parseUBits(parser, 2, 0x00006, "SoundStreamHead2::StreamSoundRate");
		final UBits streamSoundSize = parseUBits(parser, 1, 0x00006, "SoundStreamHead2::StreamSoundSize");
		final UBits streamSoundType = parseUBits(parser, 1, 0x00006, "SoundStreamHead2::StreamSoundSize");
		final UINT16 streamSoundSampleCount = parseUINT16(parser, 0x00006, "SoundStreamHead2::StreamSoundSampleCount");
		final INT16 latencySeek = parseINT16If(parser, 0x00006, streamSoundCompression.value() == 2, "SoundStreamHead2::LatencySeek");

		return new SoundStreamHead2Tag(header, reserved, playbackSoundRate,
				playbackSoundSize, playbackSoundType, streamSoundCompression,
				streamSoundRate, streamSoundSize, streamSoundType,
				streamSoundSampleCount, latencySeek);
	}
}