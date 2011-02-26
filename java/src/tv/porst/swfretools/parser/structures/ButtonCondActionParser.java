package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlag;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUBits;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;

import java.util.List;

import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.actions.Action;
import tv.porst.swfretools.parser.actions.ActionRecordParser;

/**
 * Parses ButtonCondAction structures.
 * 
 * @author sp
 *
 */
public final class ButtonCondActionParser {

	/**
	 * Parses a ButtonCondAction structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param header Previously parsed header of the tag.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static ButtonCondAction parse(final SWFBinaryParser parser, final RecordHeader header, final String fieldName) throws SWFParserException {

		final UINT16 condActionSize = parseUINT16(parser, 0x00006, fieldName + "::CondActionSize");
		final Flag condIdleToOverDown = parseFlag(parser, 0x00006, fieldName + "::CondIdleToOverDown");
		final Flag condOutDownToIdle = parseFlag(parser, 0x00006, fieldName + "::CondOutDownToIdle");
		final Flag condOutDownToOverDown = parseFlag(parser, 0x00006, fieldName + "::CondOutDownToOverDown");
		final Flag condOverDownToOutDown = parseFlag(parser, 0x00006, fieldName + "::CondOverDownToOutDown");
		final Flag condOverDownToOverUp = parseFlag(parser, 0x00006, fieldName + "::CondOverDownToOverUp");
		final Flag condOverUpToOverDown = parseFlag(parser, 0x00006, fieldName + "::CondOverUpToOverDown");
		final Flag condOverUpToIdle = parseFlag(parser, 0x00006, fieldName + "::CondOverUpToIdle");
		final Flag condIdleToOverUp = parseFlag(parser, 0x00006, fieldName + "::CondIdleToOverUp");
		final UBits condKeyPress = parseUBits(parser, 7, 0x00006, fieldName + "::CondKeyPress");
		final Flag condOverDownToIdle = parseFlag(parser, 0x00006, fieldName + "::CondOverDownToIdle");

		final int actionRecordSize = condActionSize.value() == 0 ? header.getNormalizedLength() - (parser.getBytePosition() - header.getPosition() + 1 - header.getHeaderLength()) : condActionSize.value() - 4 - 1;

		final List<Action> actions = ActionRecordParser.parse(parser, actionRecordSize);

		final UINT8 actionEndFlag = parseUINT8(parser, 0x00006, "DefineButton::ActionEndFlag");

		return new ButtonCondAction(condActionSize, condIdleToOverDown, condOutDownToIdle, condOutDownToOverDown,
				condOverDownToOutDown, condOverDownToOverUp, condOverUpToOverDown, condOverUpToIdle,
				condIdleToOverUp, condKeyPress, condOverDownToIdle, new ActionList(actions), actionEndFlag);
	}
}