package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.RectParser;

/**
 * Class for parsing DefineScalingGrid tags.
 * 
 * @author sp
 */
public final class DefineScalingGridParser {

	/**
	 * Parses a DefineScalingGrid tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static DefineScalingGridTag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final UINT16 characterId = parseUINT16(parser, 0x00006, "DefineScalingGrid::CharacterId");
		final Rect splitter = RectParser.parse(parser, "DefineScalingGrid::Splitter");

		return new DefineScalingGridTag(header, characterId, splitter);
	}
}