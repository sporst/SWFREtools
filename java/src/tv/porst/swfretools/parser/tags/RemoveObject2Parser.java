package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Class for parsing RemoveObject2 tags.
 * 
 * @author sp
 */
public final class RemoveObject2Parser {

	/**
	 * Parses a RemoveObject2 tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static RemoveObject2Tag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final UINT16 depth = parseUINT16(parser, 0x00006, "RemoveObject2::Depth");

		return new RemoveObject2Tag(header, depth);
	}
}