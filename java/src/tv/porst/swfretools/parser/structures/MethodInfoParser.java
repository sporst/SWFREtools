package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class MethodInfoParser {

	public static MethodInfo parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final EncodedU30 paramCount = EncodedU30Parser.parse(parser, fieldName + "::param_count");
		final EncodedU30 returnType = EncodedU30Parser.parse(parser, fieldName + "::return_type");

		final List<EncodedU30> paramTypes = new ArrayList<EncodedU30>();

		for (int i=0;i<paramCount.value();i++) {
			paramTypes.add(EncodedU30Parser.parse(parser, String.format(fieldName + "::param_type[%d]", i)));
		}

		final EncodedU30 name = EncodedU30Parser.parse(parser, fieldName + "::name");

		final UINT8 flags = parseUINT8(parser, 0x00006, fieldName + "::flags");

		final OptionInfo optionInfo = (flags.value() & 0x8) == 0 ? null : OptionInfoParser.parse(parser, fieldName + "::options");
		final ParamInfo paramInfo = (flags.value() & 0x80) == 0 ? null : ParamInfoParser.parse(parser, paramCount, fieldName + "::param_names");

		return new MethodInfo(paramCount, returnType, new EncodedU30List(paramTypes), name, flags, optionInfo, paramInfo);
	}

}
