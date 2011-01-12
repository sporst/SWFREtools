package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseString;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8If;
import tv.porst.splib.io.PString;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Class for parsing FrameLabel tags.
 * 
 * @author sp
 */
public final class FrameLabelParser {

	/**
	 * Parses a FrameLabel tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static FrameLabelTag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final PString name = parseString(parser, 0x00006, "FrameLabel::Name");
		final UINT8 namedAnchorFlag = parseUINT8If(parser, 0x00006, header.getNormalizedLength() == name.value().length() + 1 + 1, "FrameLabel::NamedAnchorFlag");

		return new FrameLabelTag(header, name, namedAnchorFlag);
	}
}