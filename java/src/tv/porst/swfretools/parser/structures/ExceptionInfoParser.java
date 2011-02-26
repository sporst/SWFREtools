package tv.porst.swfretools.parser.structures;

import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class ExceptionInfoParser {

	public static ExceptionInfo parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {
		final EncodedU30 from = EncodedU30Parser.parse(parser, fieldName + "::from");
		final EncodedU30 to = EncodedU30Parser.parse(parser, fieldName + "::to");
		final EncodedU30 target = EncodedU30Parser.parse(parser, fieldName + "::target");
		final EncodedU30 exc_type = EncodedU30Parser.parse(parser, fieldName + "::exc_type");
		final EncodedU30 var_name = EncodedU30Parser.parse(parser, fieldName + "::var__name");

		return new ExceptionInfo(from, to, target, exc_type, var_name);
	}

}
