package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Class for parsing SetTabIndex tags.
 * 
 * @author sp
 */
public final class SetTabIndexParser {

	/**
	 * Parses a SetTabIndex tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static SetTabIndexTag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final UINT16 depth = parseUINT16(parser, 0x00006, "SetTabIndex::Depth");
		final UINT16 tabIndex = parseUINT16(parser, 0x00006, "SetTabIndex::TabIndex");

		return new SetTabIndexTag(header, depth, tabIndex);
	}
}