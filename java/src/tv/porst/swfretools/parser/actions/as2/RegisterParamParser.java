package tv.porst.swfretools.parser.actions.as2;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseString;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;
import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class RegisterParamParser {

	public static RegisterParam parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {
		final UINT8 register = parseUINT8(parser, 0x00006, fieldName + "::Register");
		final AsciiString paramName = parseString(parser, 0x00006, "::ParamName");

		return new RegisterParam(register, paramName);
	}

}
