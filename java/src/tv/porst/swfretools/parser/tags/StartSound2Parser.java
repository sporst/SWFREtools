package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseString;
import tv.porst.splib.io.PString;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.SoundInfo;
import tv.porst.swfretools.parser.structures.SoundInfoParser;

/**
 * Class for parsing StartSound2 tags.
 * 
 * @author sp
 */
public final class StartSound2Parser {

	/**
	 * Parses a StartSound2 tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static StartSound2Tag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final PString soundClassName = parseString(parser, 0x00006, "StartSound2::SoundClassName");
		final SoundInfo soundInfo = SoundInfoParser.parse(parser, "StartSound2::SoundInfo");

		return new StartSound2Tag(header, soundClassName, soundInfo);
	}
}