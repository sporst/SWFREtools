package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.SoundInfo;
import tv.porst.swfretools.parser.structures.SoundInfoParser;

/**
 * Class for parsing StartSound tags.
 * 
 * @author sp
 */
public final class StartSoundParser {

	/**
	 * Parses a StartSound tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static StartSoundTag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final UINT16 soundId = parseUINT16(parser, 0x00006, "StartSound::SoundId");
		final SoundInfo soundInfo = SoundInfoParser.parse(parser);

		return new StartSoundTag(header, soundId, soundInfo);
	}
}