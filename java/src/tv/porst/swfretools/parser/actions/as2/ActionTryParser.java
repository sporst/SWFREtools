package tv.porst.swfretools.parser.actions.as2;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlag;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseStringIf;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUBits;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8If;

import java.util.List;

import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.ActionList;

public class ActionTryParser {

	public static ActionTry parse(final SWFBinaryParser parser, final UINT8 actionCode, final String fieldName) throws SWFParserException {

		final UINT16 length = parseUINT16(parser, 0x00006, fieldName + "::Length");
		final UBits reserved = parseUBits(parser, 5, 0x00006, fieldName + "::Reserved");
		final Flag catchInRegisterFlag = parseFlag(parser, 0x00006, fieldName + "::CatchInRegisterFlag");
		final Flag finallyBlockFlag = parseFlag(parser, 0x00006, fieldName + "::FinallyBlockFlag");
		final Flag catchBlockFlag = parseFlag(parser, 0x00006, fieldName + "::CatchBlockFlag");
		final UINT16 trySize = parseUINT16(parser, 0x00006, fieldName + "::TrySize");
		final UINT16 catchSize = parseUINT16(parser, 0x00006, fieldName + "::CatchSize");
		final UINT16 finallySize = parseUINT16(parser, 0x00006, fieldName + "::FinallySize");

		final AsciiString functionName = parseStringIf(parser, 0x00006, catchInRegisterFlag, "::FunctionName");
		final UINT8 registerCount = parseUINT8If(parser, 0x00006, catchInRegisterFlag, fieldName + "::RegisterCount");

		final List<Action> tryBody = ActionRecordParser.parse(parser, trySize.value(), fieldName + "::TryBody");
		final List<Action> catchBody = ActionRecordParser.parse(parser, catchSize.value(), fieldName + "::CatchBody");
		final List<Action> finallyBody = ActionRecordParser.parse(parser, finallySize.value(), fieldName + "::FinallyBody");

		return new ActionTry(actionCode, length, reserved, catchInRegisterFlag, finallyBlockFlag,
				catchBlockFlag, trySize, catchSize, finallySize, functionName, registerCount,
				new ActionList(tryBody), new ActionList(catchBody), new ActionList(finallyBody));
	}
}