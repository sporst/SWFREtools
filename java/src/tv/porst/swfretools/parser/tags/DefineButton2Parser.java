package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseBits;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlag;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.Flag;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.actions.Action;
import tv.porst.swfretools.parser.actions.ActionRecordParser;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Class for parsing DefineButton2 tags.
 * 
 * @author sp
 */
public final class DefineButton2Parser {

	/**
	 * Parses a DefineButton2 tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static DefineButton2Tag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final UINT16 buttonId = parseUINT16(parser, 0x00006, "DefineButton2::ButtonId");
		final int reservedFlags = parseBits(parser, 7, 0x00006, "DefineButton2::ReservedFlags");
		final Flag trackAsMenu = parseFlag(parser, 0x00006, "DefineButton2::TrackAsMenu");
		final UINT16 actionOffset = parseUINT16(parser, 0x00006, "DefineButton2::ActionOffset");

		final List<ButtonRecord2> characters = new ArrayList<ButtonRecord2>();

		do
		{
			if (parser.peekUInt8() == 0) {
				break;
			}

			characters.add(ButtonRecord2Parser.parse(parser, String.format("DefineButton2::Characters[%d]", characters.size())));

		} while (true);

		final int actionRecordSize = header.getNormalizedLength() - parser.getBytePosition() - 1;

		final List<Action> actions = ActionRecordParser.parse(parser, actionRecordSize);

		final UINT8 actionEndFlag = parseUINT8(parser, 0x00006, "DefineButton::ActionEndFlag");

		return new DefineButton2Tag(header, buttonId, reservedFlags, trackAsMenu, actionOffset, characters, actions, actionEndFlag);
	}
}