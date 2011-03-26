package tv.porst.swfretools.parser.structures;

import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class MultinameAParser {

	public static MultinameA parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {
		final EncodedU30 name = EncodedU30Parser.parse(parser, fieldName + "::name");
		final EncodedU30 nsSet = EncodedU30Parser.parse(parser, fieldName + "::ns_set");

		return new MultinameA(name, nsSet);
	}
}
