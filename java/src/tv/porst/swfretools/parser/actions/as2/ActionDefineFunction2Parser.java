package tv.porst.swfretools.parser.actions.as2;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlag;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseString;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUBits;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.ActionList;

public class ActionDefineFunction2Parser {

	public static ActionDefineFunction2 parse(final SWFBinaryParser parser, final UINT8 actionCode, final String fieldName) throws SWFParserException {

		final UINT16 length = parseUINT16(parser, 0x00006, fieldName + "::Length");
		final AsciiString functionName = parseString(parser, 0x00006, "::FunctionName");
		final UINT16 numParams = parseUINT16(parser, 0x00006, fieldName + "::NumParams");
		final UINT8 registerCount = parseUINT8(parser, 0x00006, fieldName + "::RegisterCount");
		final Flag preloadParentFlag = parseFlag(parser, 0x00006, fieldName + "::PreloadParentFlag");
		final Flag preloadRootFlag = parseFlag(parser, 0x00006, fieldName + "::PreloadRootFlag");
		final Flag suppressSuperFlag = parseFlag(parser, 0x00006, fieldName + "::SuppressSuperFlag");
		final Flag preloadSuperFlag = parseFlag(parser, 0x00006, fieldName + "::PreloadSuperFlag");
		final Flag suppressArgumentsFlag = parseFlag(parser, 0x00006, fieldName + "::SuppressArgumentsFlag");
		final Flag preloadArgumentsFlag = parseFlag(parser, 0x00006, fieldName + "::PreloadArgumentsFlag");
		final Flag suppressThisFlag = parseFlag(parser, 0x00006, fieldName + "::SuppressThisFlag");
		final Flag preloadThisFlag = parseFlag(parser, 0x00006, fieldName + "::PreloadThisFlag");
		final UBits reserved = parseUBits(parser, 7, 0x00006, fieldName + "::Reserved");
		final Flag preloadGlobalFlag = parseFlag(parser, 0x00006, fieldName + "::PreloadGlobalFlag");

		final List<RegisterParam> registerParams = new ArrayList<RegisterParam>();

		for (int i=0;i<numParams.value();i++) {
			registerParams.add(RegisterParamParser.parse(parser, fieldName + String.format("::RegisterParams[%d]", i)));
		}

		final UINT16 codeSize = parseUINT16(parser, 0x00006, fieldName + "::CodeSize");

		final List<Action> code = ActionRecordParser.parse(parser, codeSize.value(), fieldName + "::Code");

		return new ActionDefineFunction2(actionCode, length, functionName, numParams, registerCount, preloadParentFlag,
				preloadRootFlag, suppressSuperFlag, preloadSuperFlag, suppressArgumentsFlag,
				preloadArgumentsFlag, suppressThisFlag, preloadThisFlag, reserved, preloadGlobalFlag,
				new RegisterParamList(registerParams), codeSize, new ActionList(code));
	}

}
