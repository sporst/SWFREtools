package tv.porst.swfretools.parser.tags;

import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.RGB;
import tv.porst.swfretools.parser.structures.RGBParser;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Class for parsing SetBackgroundColor tags.
 * 
 * @author sp
 */
public final class SetBackgroundColorParser {

	/**
	 * Parses a SetBackgroundColor tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static SetBackgroundColorTag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final RGB backgroundColor = RGBParser.parse(parser, "SetBackgroundColor::BackgroundColor");

		return new SetBackgroundColorTag(header, backgroundColor);
	}
}