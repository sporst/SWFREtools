package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;

import java.util.List;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.actions.as2.Action;
import tv.porst.swfretools.parser.actions.as2.ActionRecordParser;
import tv.porst.swfretools.parser.structures.ActionList;
import tv.porst.swfretools.parser.structures.RecordHeader;


/**
 * Class for parsing DoInitAction tags.
 * 
 * @author sp
 */
public final class DoInitActionParser {

	/**
	 * Parses a DoInitAction tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static DoInitActionTag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final UINT16 spriteId = parseUINT16(parser, 0x00006, "DoInitAction::SpriteId");

		final List<Action> actions = ActionRecordParser.parse(parser, header.getNormalizedLength() - 2, "DoInitAction::Actions");

		return new DoInitActionTag(header, spriteId, new ActionList(actions));
	}
}