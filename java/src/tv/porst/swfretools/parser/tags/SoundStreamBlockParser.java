package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseByteArray;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.ByteArray;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Class for parsing SoundStreamBlock tags.
 * 
 * @author sp
 */
public final class SoundStreamBlockParser {

	/**
	 * Parses a SoundStreamBlock tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static SoundStreamBlockTag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final ByteArray streamSoundData = parseByteArray(parser, header.getNormalizedLength(), 0x00006, "SoundStreamBlock::StreamSoundData");

		return new SoundStreamBlockTag(header, streamSoundData);
	}
}