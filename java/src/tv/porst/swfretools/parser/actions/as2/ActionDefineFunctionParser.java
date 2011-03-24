package tv.porst.swfretools.parser.actions.as2;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseString;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.ActionList;
import tv.porst.swfretools.parser.structures.StringList;

public class ActionDefineFunctionParser {

	public static ActionDefineFunction parse(final SWFBinaryParser parser, final UINT8 actionCode, final String fieldName) throws SWFParserException {

		final UINT16 length = parseUINT16(parser, 0x00006, fieldName + "::Length");
		final AsciiString functionName = parseString(parser, 0x00006, "::FunctionName");
		final UINT16 numParams = parseUINT16(parser, 0x00006, fieldName + "::NumParams");
		final List<AsciiString> params = new ArrayList<AsciiString>();

		for (int i=0;i<numParams.value();i++) {
			params.add(parseString(parser, 0x00006, fieldName + String.format("::RegisterParams[%d]", i)));
		}

		final UINT16 codeSize = parseUINT16(parser, 0x00006, fieldName + "::CodeSize");
		final List<Action> code = ActionRecordParser.parse(parser, codeSize.value(), fieldName + "::Code");

		return new ActionDefineFunction(actionCode, length, functionName, numParams, new StringList(params), codeSize, new ActionList(code));
	}

}
