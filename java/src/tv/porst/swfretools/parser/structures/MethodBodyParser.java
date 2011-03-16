package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.actions.as3.AS3CodeParser;

public class MethodBodyParser {

	public static MethodBody parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {
		final EncodedU30 method = EncodedU30Parser.parse(parser, fieldName + "::method");
		final EncodedU30 maxStack = EncodedU30Parser.parse(parser, fieldName + "::max_stack");
		final EncodedU30 localCount = EncodedU30Parser.parse(parser, fieldName + "::local_count");
		final EncodedU30 initScopeDepth = EncodedU30Parser.parse(parser, fieldName + "::init_scope_depth");
		final EncodedU30 maxScopeDepth = EncodedU30Parser.parse(parser, fieldName + "::max_scope_depth");
		final EncodedU30 codeLength = EncodedU30Parser.parse(parser, fieldName + "::code_length");

		final AS3Code code = AS3CodeParser.parse(parser, (int) codeLength.value(), fieldName + "::code");

		final EncodedU30 exceptionCount = EncodedU30Parser.parse(parser, fieldName + "::exception_count");

		final List<ExceptionInfo> exceptions = new ArrayList<ExceptionInfo>();

		for (int i=0;i<exceptionCount.value();i++) {
			exceptions.add(ExceptionInfoParser.parse(parser, String.format(fieldName + "::exception[%d]", i)));
		}

		final EncodedU30 traitCount = EncodedU30Parser.parse(parser, fieldName + "::trait_count");

		final List<TraitsInfo> traits = new ArrayList<TraitsInfo>();

		for (int i=0;i<traitCount.value();i++) {
			traits.add(TraitsInfoParser.parse(parser, String.format(fieldName + "::trait[%d]", i)));
		}

		return new MethodBody(method, maxStack, localCount, initScopeDepth, maxScopeDepth, codeLength, code, exceptionCount, exceptions, traitCount, traits);
	}

}
