package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseBits;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseByteArray;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT32;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT32;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.ByteArray;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Class for parsing DefineSound tags.
 * 
 * @author sp
 */
public final class DefineSoundParser {

	/**
	 * Parses a DefineSound tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static DefineSoundTag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final UINT16 soundId = parseUINT16(parser, 0x00006, "DefineSound::SoundId");
		final int soundFormat = parseBits(parser, 4, 0x00006, "DefineSound::SoundFormat");
		final int soundRate = parseBits(parser, 2, 0x00006, "DefineSound::SoundRate");
		final int soundSize = parseBits(parser, 1, 0x00006, "DefineSound::SoundSize");
		final int soundType = parseBits(parser, 1, 0x00006, "DefineSound::SoundType");
		final UINT32 soundSampleCount = parseUINT32(parser, 0x00006, "DefineSound::SoundSampleCount");

		final int remainingBytes = header.getNormalizedLength() - 2 - 1 - 4;

		final ByteArray soundData = parseByteArray(parser, remainingBytes, 0x00006, "DefineSound::SoundData");

		return new DefineSoundTag(header, soundId, soundFormat, soundRate, soundSize, soundType, soundSampleCount, soundData);
	}
}