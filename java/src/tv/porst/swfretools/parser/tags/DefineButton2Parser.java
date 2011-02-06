package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlag;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUBits;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.ButtonCondAction;
import tv.porst.swfretools.parser.structures.ButtonCondActionParser;
import tv.porst.swfretools.parser.structures.ButtonRecord2;
import tv.porst.swfretools.parser.structures.ButtonRecord2Parser;
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
		final UBits reservedFlags = parseUBits(parser, 7, 0x00006, "DefineButton2::ReservedFlags");
		final Flag trackAsMenu = parseFlag(parser, 0x00006, "DefineButton2::TrackAsMenu");
		final UINT16 actionOffset = parseUINT16(parser, 0x00006, "DefineButton2::ActionOffset");

		final List<ButtonRecord2> characters = new ArrayList<ButtonRecord2>();

		do {
			if (parser.peekUInt8().value() == 0) {
				break;
			}

			characters.add(ButtonRecord2Parser.parse(parser, String.format("DefineButton2::Characters[%d]", characters.size())));

		} while (true);

		final UINT8 characterEndFlag = parseUINT8(parser, 0x00006, "DefineButton2::CharacterEndFlag");

		final List<ButtonCondAction> actions = new ArrayList<ButtonCondAction>();

		if (actionOffset.value() != 0) {

			do {
				final ButtonCondAction action = ButtonCondActionParser.parse(parser, header, String.format("DefineButton2::ButtonCondAction[%d]", actions.size()));

				actions.add(action);

				if (action.getCondActionSize().value() == 0) {
					break;
				}

			} while (true);
		}

		return new DefineButton2Tag(header, buttonId, reservedFlags, trackAsMenu, actionOffset, characters, characterEndFlag, actions);
	}
}